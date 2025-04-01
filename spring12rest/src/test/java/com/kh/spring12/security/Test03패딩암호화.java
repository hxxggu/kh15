package com.kh.spring12.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test03패딩암호화 {
	
	@Test
	public void test() {
		String origin = "hello"; // 원 문구
		String convert = encrypt(origin); // 암호화된 문구
		String recover = decrypt(convert); // 복호화된 문구
		log.debug("origin = {}", origin);
		log.debug("convert = {}", convert);
		log.debug("recover = {}", recover);
	}
	
	private char padding = 'a'; // padding : 알려지면 안됨
	public String encrypt(String origin) { // 암호화
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<origin.length(); i++) {
			char ch = origin.charAt(i);
			buffer.append(ch); // 글자 추가 후
			buffer.append(padding); // 패딩 추가
		}
		return buffer.toString();
	}
	
	public String decrypt(String convert) { // 복호화
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<convert.length(); i+=2) { // 홀수 자리만 반복
			char ch = convert.charAt(i);
			buffer.append(ch);
		}
		return buffer.toString();
	}
}
