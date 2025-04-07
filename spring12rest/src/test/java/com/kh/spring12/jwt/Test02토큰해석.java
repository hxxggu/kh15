package com.kh.spring12.jwt;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test02토큰해석 {
	
	@Test
	public void test() {
		// 이미 만들어져 있는 토큰을 해석
		
		// [1] 토큰 문자열 준비 (띄어쓰기도 삽입X, 주의)
		String token = "eyJhbGciOiJIUzM4NCJ9.eyJleHAiOjE3NDM3NDk1NzIsImlzcyI6IktI7KCV67O06rWQ7Jyh7JuQIiwiaWF0IjoxNzQzNzQzNTcyLCJ1c2VySWQiOiJ0ZXN0dXNlcjEiLCJ1c2VyTGV2ZWwiOiLsnbzrsJjtmozsm5AifQ.HvFKXzxxaSw1lCqWiYxFO274ft-rQ9at-8PPNdYBYY00h_Xrppc_WXjo7HPiCXWX";
		
		// [2] 해석을 위한 열쇠 준비
		String keyString = "aahsdjhakljjdbjksjkvshkuryskhjsdjfhsklhfjhsakfbh";
		SecretKey key = Keys.hmacShaKeyFor(keyString.getBytes(StandardCharsets.UTF_8));
		
		// [3] 토큰 해석
		Claims claims = (Claims)Jwts.parser() // 다운 캐스팅
			.verifyWith(key) // 검증에 사용할 비밀키 설정
			.requireIssuer("KH정보교육원") // 발행자 검사 (생략 가능)
			.build() // 위의 정보로 해석 도구를 생성
			.parse(token) // 토큰을 해석
			.getPayload(); // 해석된 정보를 가져오세요
		
		// [4] 정보 출력
		String userId = (String) claims.get("userId");
		log.debug("userId = {}", userId);
		String userLevel = (String) claims.get("userLevel");
		log.debug("userLevel = {}", userLevel);
	}
}
