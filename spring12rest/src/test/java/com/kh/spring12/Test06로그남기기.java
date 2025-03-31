package com.kh.spring12;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j // Lombok에서 제공하는 자동 로거 생성 어노테이션
@SpringBootTest
public class Test06로그남기기 {
	
	// 로그를 남기려면 로깅 로그를 생성해야 한다
	// Logger log = LoggerFactory.getLogger(Test06로그남기기.class);
	// spring에서는 slf4j로 log를 읽어올 수 있음 (import 할 때 유의할 것)
	
	@Test
	public void test() { 
		log.debug("디버그");
		log.info("인포");
		log.warn("경고 메시지");
		log.error("에러 메시지");
		
		// 로그를 사용할 때 좋은 점 : 더하기를 그만 써도 된다
		int a = 10;
		int b = 20;
		System.out.println(a+"+"+b+"="+(a+b));
		log.debug("a = {}", a);
		log.debug("{} + {} = {}", a, b, a+b);
	}

}
