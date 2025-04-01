package com.kh.spring12.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder; // BCryptPasswordEncoder의 상위 폴더

@Configuration // application.properties에서 할 수 없는 추가 설정을 하는 파일
public class SecurityConfiguration {
	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

}
