package com.kh.spring12.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.spring12.configuration.KakaoPayProperties;
import com.kh.spring12.vo.kakaopay.KakaoPayApproveResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayApproveVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyVO;

@Service
public class KakaoPayService {
	
	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	
	// 결제 준비 (ready)
	public KakaoPayReadyResponseVO ready(KakaoPayReadyVO vo) throws URISyntaxException {
		
		// 1. 전송 도구 생성
		RestTemplate restTemplate = new RestTemplate();
		
		// 2. 전송 주소 확인
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/ready");
		
		// 3. 헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "SECRET_KEY " + kakaoPayProperties.getSecretKey());
		headers.add("Content-Type", "application/json");
		
		// 4. 바디 설정
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid()); // body.put("이름", "값");
		body.put("partner_order_id", vo.getPartnerOrderId());
		body.put("partner_user_id", vo.getPartnerUserId());
		body.put("item_name", vo.getItemName());
		body.put("quantity", "1");
		body.put("total_amount", String.valueOf(vo.getTotalAmount()));
		body.put("tax_free_amount", "0");
		// * 카카오페이 개발자센터 플랫폼에 등록된 주소로 시작해야 함
		body.put("approval_url", "http://localhost:8080/api/kakaopay/v1/approve" + vo.getPartnerOrderId()); // 회원만 결제할 수 있도록 구현
		body.put("cancel_url", "http://localhost:8080/api/kakaopay/v1/cancel");
		body.put("fail_url", "http://localhost:8080/api/kakaopay/v1/fail");
		
		// 4 + 3
		HttpEntity entity = new HttpEntity(body, headers);
		
		// 2 + (4 + 3)
		KakaoPayReadyResponseVO response =
				restTemplate.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
		
		return response;
	}
	
	// 결제 승인 (approve)
	public KakaoPayApproveResponseVO approve(KakaoPayApproveVO vo) throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/approve");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "SECRET_KEY " + kakaoPayProperties.getSecretKey());
		headers.add("Content-Type", "application/json");
		
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid()); // 가맹점 번호
		body.put("tid", vo.getTid());
		body.put("partner_order_id", vo.getPartnerOrderId());
		body.put("partner_user_id", vo.getPartnerUserId());
		body.put("pg_token", vo.getPgToken());
		
		HttpEntity entity = new HttpEntity(body, headers);
		KakaoPayApproveResponseVO response = restTemplate.postForObject(uri, entity, KakaoPayApproveResponseVO.class);
		
		return response;
}
	// 
}
