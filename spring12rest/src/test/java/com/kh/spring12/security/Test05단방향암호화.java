package com.kh.spring12.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test05단방향암호화 {
	
	@Test
	public void test() {
		// 단방향 암호화의 핵심은 원래 값으로 되돌릴 수 없도록 값을 훼손 시키는 것
		int origin = 1;
		int encrypt = (origin + 12345) % 10;
		
		log.debug("origin = {}", origin);
		log.debug("encrypt = {}", encrypt);
	}
}
