package com.kh.spring12.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test02XOR암호화 {
	
	@Test
	public void test() {
		// 비트 연산자 - &, |, ^, ~
		// - 비트(bit) 단위로 수행하는 연산
		
		String origin = "hello";
		String convert = encrypt(origin);
		String recover = decrypt(convert);
		log.debug("origin = {}", origin);
		log.debug("convert = {}", convert);
		log.debug("recover = {}", recover);
	}
	
	private int offset = 5;
	public String encrypt(String origin) { // 암호화
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<origin.length(); i++) {
			char ch = origin.charAt(i);
			ch ^= offset;
			buffer.append(ch);
		}
		return buffer.toString();
	}
	
	public String decrypt(String convert) { // 복호화
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<convert.length(); i++) {
			char ch = convert.charAt(i);
			ch ^= offset;
			buffer.append(ch);
		}
		return buffer.toString();
	}

}
