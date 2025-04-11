package com.kh.spring12.kakaopay;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

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
public class Test02단건결제승인 {
	
	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	
	@Test
	public void test() throws URISyntaxException {
		// 1. 전송 도구 생성
		RestTemplate restTemplate = new RestTemplate();
		
		// 2. 전송 주소 확인
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/approve");
		
		// 3. 헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "SECRET_KEY " + kakaoPayProperties.getSecretKey());
		headers.add("Content-Type", "application/json");
		
		// 4. 바디 설정
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("tid", "T7f8a6301b530bd8fa65");
		body.put("partner_order_id", "e0a3e68a-356c-4a2c-9be2-e73802871294");
		body.put("partner_user_id", "testuser1");
		body.put("pg_token", "907bec6aab3eedfc047c");
		
		// 4 + 3
		HttpEntity entity = new HttpEntity(body, headers);
		
		// 2 + (4 + 3)
		Map response = restTemplate.postForObject(uri, entity, Map.class); // Map은 알아서 받아줌(연습할 때는 일단 Map 사용)
		// log.debug("response = {}", response);
		
		for(Object name : response.keySet()) {
			Object value = response.get(name);
			log.debug("{} = {}", name, value);
		}
	}
}
