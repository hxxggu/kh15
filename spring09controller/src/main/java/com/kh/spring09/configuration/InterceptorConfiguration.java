package com.kh.spring09.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kh.spring09.aop.MemberLoginInterceptor;
import com.kh.spring09.aop.TestLogInterceptor;

//설정파일(Configuration)
//- application.properties에서 할 수 없는 복잡한 설정을 구현할 때 사용
//- @Configuration으로 등록
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer { //configuration은 한 개만 있어도 됨, interception은 필요한 만큼 생성
	
	@Autowired
	private TestLogInterceptor testLogInterceptor;
	
	@Autowired
	private MemberLoginInterceptor memberLoginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//필요한 주소에 인터셉터를 등록
		registry.addInterceptor(testLogInterceptor).addPathPatterns("/**");
		
		//회원 전용 기능에 대해 인터셉터를 등록
		//- 와일드카드를 한개(*) 쓰면 엔드포인트를 유지하며 패턴 검색
		//- 와일드카드를 두개(**) 쓰면 엔드포인트 이하의 모든 주소 패턴 검색
		registry.addInterceptor(memberLoginInterceptor).addPathPatterns(List.of(
				"/member/**",
				"/game-user/**"
				))
				.excludePathPatterns(List.of(
					//"/member/join",
					//"/member/joinFinish",
					"/member/join*",
					"/member/login",
					"/member/exitFinish"
				));
	}
}
