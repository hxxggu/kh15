package com.kh.spring12.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

/**
	JWT (Json Web Token)
	- 웹 인증을 목적으로 3개의 영역으로 데이터를 구분하여 만든 문자열 코드
	- 제 1영역 : 알고리즘의 정보
	- 제 2영역 : 실제 데이터
	- 제 3영역 : 변조 방지를 위한 서명
	
	- 로그인 성공 시 정보를 JWT 토큰에 담아 위변조 방지 및 시간 기록 후 전송
	- 클라이언트는 앞으로 모든 요청에 이 토큰을 담아서 전송해야 함
	- 서버는 토큰을 분석해서 사용자의 로그인 상태와 권한 등을 파악할 수 있음
	
	- 암호화를 할 때, 서버에서 임의의 문자열을 첨부(secret key)하므로 키만 걸리지 않으면 안전함
	
	- 다양한 생성 기술 중에서 jjwt 라는 기술을 사용
 */

@Slf4j
@SpringBootTest
public class Test01토큰생성 {
	
	@Test
	public void test() {
		// [1] 암호화에 사용할 비밀키 생성 (충분히 길게 작성 = 32글자 이상)
		String keyString = "aahsdjhakljjdbjksjkvshkuryskhjsdjfhsklhfjhsakfbh";
		SecretKey key = Keys.hmacShaKeyFor(keyString.getBytes(StandardCharsets.UTF_8));
		// hmac sha key, sha key 둘의 차이 : 열쇠를 갖는지 아닌지의 차이 (hmac sha: O, sha: X)
		
		// [2] 이 토큰의 만료 시간을 계산 (java.util.Date)
		// - 토큰은 쿠키랑 비슷함. 시간이 만료되면 연장 작업이 필요.
		Calendar c = Calendar.getInstance();
		Date now = c.getTime(); // 현재 시각 / java.util.Date : import 시 주의
		
		c.add(Calendar.MINUTE, 100);
		Date limit = c.getTime(); // 만료 시각
		
		// [3] JWT 토큰 생성
		String token = Jwts.builder()
			// 토큰에 대한 정보 입력
			.signWith(key) // 변조 및 해독에 사용할 키 정보
			.expiration(limit) // 만료 시각 설정 (해당 시각까지만 작동함)
			.issuer("KH정보교육원") // 발행자 정보, 타인이 모르게 하는 것을 권장
			.issuedAt(now) // 발행 시각 설정
			// 정보 추가 claim(key, value)
			// - 최소한의 정보만을 추가, 데이터 과다 시 속도 저하
			.claim("userId", "testuser1")
			.claim("userLevel", "일반회원")
		.compact();
		
		// [4] 출력
		log.debug("token = {}", token);
	}

}
