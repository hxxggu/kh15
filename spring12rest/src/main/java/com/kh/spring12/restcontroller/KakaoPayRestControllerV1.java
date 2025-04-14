package com.kh.spring12.restcontroller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.error.TargetNotFoundException;
import com.kh.spring12.service.KakaoPayService;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.ClaimVO;
import com.kh.spring12.vo.kakaopay.KakaoPayApproveResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayApproveVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyVO;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@CrossOrigin // react에서 ajax로 결제 요청보내니까 필요
@RestController
@RequestMapping("/api/kakaopay/v1")
public class KakaoPayRestControllerV1 {
	
	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Autowired
	private TokenService tokenService;
	
	// Flash value를 저장하기 위한 저장소
	// - 웹은 기본적으로 멀티스레드 환경이기 때문에 저장소를 만들 때는 "동기화"
	// private Map<아이디, 결제승인요청정보> flashMap = new HashMap<>();
	// private Map<String, KakaoPayApproveVO> flashMap = new HashMap<>();
	// 해당 코드 사용 시 thread-safe 에러 발생 (thread-safe: 여러 스레드가 동시에 flashMap에 접근하거나 수정할 경우 에러 발생)
	// : HashMap은 기본적으로 동기화되지 않은 컬렉션이라 동시 접근 시 NullPointerException, NullPointerException 예외 발생
	private Map<String, KakaoPayApproveVO> flashMap = Collections.synchronizedMap(new HashMap<>()); // thread-safe

	@PostMapping("/buy")
	public KakaoPayReadyResponseVO ready(
			@RequestBody KakaoPayReadyVO vo,
			@RequestHeader("Authorization") String bearerToken) throws URISyntaxException {
		// VO에는 상품명(itemName)과 결제 금액(totalAmount)만 있음
		vo.setPartnerOrderId(UUID.randomUUID().toString());
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken); 
		vo.setPartnerUserId(claimVO.getUserId()); // testuser1 이라고 쓰면 타인은 결제를 할 수 없음, 해당하는 값을 토큰에서 꺼내와야 함 (TokenService 이용)
		
		KakaoPayReadyResponseVO response = kakaoPayService.ready(vo);
		
		// 승인을 위해 flashMap 정보를 저장
		// flashMap.put(아이디, VO);
		flashMap.put(vo.getPartnerOrderId(),
			KakaoPayApproveVO.builder()
				.tid(response.getTid()) // 거래번호
				.partnerOrderId(vo.getPartnerOrderId()) // 주문번호
				.partnerUserId(vo.getPartnerUserId()) // 주문자
			.build());
		
		return response;
	}
		
	@GetMapping("/buy/success/{partnerOrderId}")
	public void approve(
			@PathVariable String partnerOrderId,
			@RequestParam("pg_token") String pgToken,
			HttpServletResponse response
			) throws URISyntaxException, IOException {
		// System.out.println("[approve] sesison : " + session.getId());
		// >> session 으로 처리하려고 했으나 사용 불가능, 데이터 연결이 안됨
		KakaoPayApproveVO vo = flashMap.get(partnerOrderId);
		if(vo == null) throw new TargetNotFoundException("유효하지 않은 결제 정보");
		
		flashMap.remove(partnerOrderId); // 한번 사용했으면 정보에 대해 지울 것		
		vo.setPgToken(pgToken);
		KakaoPayApproveResponseVO approveResponse = kakaoPayService.approve(vo);
		
		response.sendRedirect("http://localhost:5173/pay/v1/success");
	}
	
	@GetMapping("/buy/cancel/{partnerOrderId}")
	public void cancel(
			HttpServletResponse response,
			@PathVariable String partnerOrderId
			) throws IOException {
		flashMap.remove(partnerOrderId);
		response.sendRedirect("http://localhost:5173/pay/v1/cancel");
	}
	
	@GetMapping("/buy/fail")
	public void fail(
			HttpServletResponse response,
			@PathVariable String partnerOrderId
			) throws IOException {
		flashMap.remove(partnerOrderId);
		response.sendRedirect("http://localhost:5173/pay/v1/fail");
	}
}
