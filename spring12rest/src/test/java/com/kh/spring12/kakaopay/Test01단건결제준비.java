package com.kh.spring12.kakaopay;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.kh.spring12.configuration.KakaoPayProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test01단건결제준비 {
	
	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	
	@Test
	public void test() throws URISyntaxException {
		// UUID(Universally Unique Identifier) : 컴퓨터 시스템에서 객체를 고유하게 식별하기 위한 128비트의 식별자
		// : 절대 겹치지 않음 (식별하기 위한 key 이기 때문)
		String partnerOrderId = UUID.randomUUID().toString();
		String partnerUserId = "testuser1";
		String itemName = "최고급 노트북";
		int totalAmount = 2000000;
		
		// * Spring Boot에서 서버로 메시지를 보내는 방법
		// [1] RestTemplate을 이용하는 방법 (지금도 가능) :: 실제 실습할 방법
		// [2] WebClient를 이용하는 방법 (spring-webflux 필요) :: Spring에서는 이쪽 방법을 권장
		
		// 1. 전송 도구 생성
		RestTemplate restTemplate = new RestTemplate();
		
		// 2. 전송 주소 확인
		// : uri가 url 대비 좀더 넓은 의미의 주소
//		POST /online/v1/payment/ready HTTP/1.1
//		Host: open-api.kakaopay.com
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/ready");
		
		// 3. 헤더 설정
//		Authorization: SECRET_KEY ${SECRET_KEY}
//		Content-Type: application/json
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "SECRET_KEY " + kakaoPayProperties.getSecretKey());
		headers.add("Content-Type", "application/json");
		
		// 4. 바디 설정
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid()); // body.put("이름", "값");
		body.put("partner_order_id", partnerOrderId);
		body.put("partner_user_id", partnerUserId);
		body.put("item_name", itemName);
		body.put("quantity", "1");
		body.put("total_amount", String.valueOf(totalAmount));
		body.put("tax_free_amount", "0");
		// * 카카오페이 개발자센터 플랫폼에 등록된 주소로 시작해야 함
		body.put("approval_url", "http://localhost:8080/success");
		body.put("cancel_url", "http://localhost:8080/cancel");
		body.put("fail_url", "http://localhost:8080/fail");
		// kakao는 CamelCase를 사용하지 않음. 여기에서는 적용X.
		
		// 4 + 3
		// HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers); // 정석적인 방법 (but, 이해하기 어려움)
		HttpEntity entity = new HttpEntity(body, headers); // : 제너릭타입을 적지 않아서 경고 발생
		
		// 2 + (4 + 3)
		// Map response = restTemplate.postForObject(주소객체, 헤더+바디, 결과물의형태);
		// 위의 세 가지를 알려줘서 통신을 보내게 함
		Map response = restTemplate.postForObject(uri, entity, Map.class); // Map은 알아서 받아줌(연습할 때는 일단 Map 사용)
		// log.debug("response = {}", response);
			
		System.out.println("partnerOrderId : " + partnerOrderId);
		System.out.println("partnerUserId : " +partnerUserId);
		System.out.println("tid : " + response.get("tid"));
		System.out.println("url : " + response.get("next_redirect_pc_url"));
//		for(Object name : response.keySet()) {
//			Object value = response.get(name);
//			log.debug("{} = {}", name, value);
//			System.out.println(name + "=" + value);
//		}
	}
}
