package com.kh.spring12.restcontroller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.BuyDao;
import com.kh.spring12.dto.BuyDto;
import com.kh.spring12.error.TargetNotFoundException;
import com.kh.spring12.service.KakaoPayService;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.ClaimVO;
import com.kh.spring12.vo.kakaopay.BuyTotalVO;
import com.kh.spring12.vo.kakaopay.KakaoPayOrderResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayOrderVO;

@CrossOrigin
@RestController
@RequestMapping("/api/buy")
public class BuyRestController {
	
	@Autowired
	private BuyDao buyDao;
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private KakaoPayService kakaoPayService;
	
	@GetMapping("/")
	public List<BuyTotalVO> list(
			@RequestHeader("Authorization") String bearerToken) {
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
//		return buyDao.listTotalManual(cliamVO.getUserId());
		return buyDao.listTotalAuto(claimVO.getUserId());
	}
	
	// 항목명만 쓸 수 있는 경우는 해당값이 Primary key 일 때만 가능
	@GetMapping("/{buyNo}") // 바람직한 방식 (PK 사용)
	public KakaoPayOrderResponseVO order(
			@PathVariable long buyNo,
			@RequestHeader("Authorization") String bearerToken
			) throws URISyntaxException {
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
		BuyDto buyDto = buyDao.selectOne(buyNo);
		
		// 요청자와 구매자가 다르면 차단
		if(claimVO.getUserId().equals(buyDto.getBuyOwner()) == false) {
			throw new TargetNotFoundException();
		}
		
		return kakaoPayService.order(KakaoPayOrderVO.builder()
				.tid(buyDto.getBuyTid())
			.build());
	}
	
	// 상단 코드와 같은 기능 / primary key로 조회하는 코드 지향
//	@GetMapping("/buyTid/{buyTid}")
//	public KakaoPayOrderResponseVO order(@PathVariable String buyTid) throws URISyntaxException {
//		return kakaoPayService.order(KakaoPayOrderVO.builder()
//					.tid(buyTid)
//				.build());
//	}
	
	
}