package com.kh.spring12.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

@SpringBootTest
public class Test01토큰생성 {
	
	@Test
	public void test() {
		
	}

}
