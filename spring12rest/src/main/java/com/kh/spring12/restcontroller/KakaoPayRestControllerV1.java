package com.kh.spring12.restcontroller;

import java.net.URISyntaxException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.service.KakaoPayService;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.ClaimVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyVO;

@CrossOrigin // react에서 ajax로 결제 요청보내니까 필요
@RestController
@RequestMapping("/api/kakaopay/v1")
public class KakaoPayRestControllerV1 {
	
	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/ready")
	public KakaoPayReadyResponseVO ready(
			@RequestBody KakaoPayReadyVO vo,
			@RequestHeader("Authorization") String bearerToken) throws URISyntaxException {
		// vo에는 상품명(itemName)과 결제 금액(totalAmount)만 있음
		vo.setPartnerOrderId(UUID.randomUUID().toString());
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken); 
		vo.setPartnerUserId(claimVO.getUserId());
		// testuser1 이라고 쓰면 타인은 결제를 할 수 없음, 해당하는 값을 토큰에서 꺼내와야 함 (TokenService 이용)
		
		return kakaoPayService.ready(vo);
	}
}
