package com.kh.spring09.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kh.spring09.aop.TestLogInterceptor;

//설정파일(Configuration)
//- application.properties에서 할 수 없는 복잡한 설정을 구현할 때 사용
//- @Configuration으로 등록
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer { //configuration은 한 개만 있어도 됨, interception은 필요한 만큼 생성
	
	@Autowired
	private TestLogInterceptor testLogInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//필요한 주소에 인터셉터를 등록
		registry.addInterceptor(testLogInterceptor).addPathPatterns("/**");
	}
}
