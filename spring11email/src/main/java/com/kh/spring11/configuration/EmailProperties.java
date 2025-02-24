package com.kh.spring11.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

// application.properties 와 같은 설정 파일의 내용을 프로그램에 연동하는 파일
@Data
@Component
@ConfigurationProperties(prefix = "custom.email")
public class EmailProperties {
	private String username; // custom.email.username : custom.email 의 username 을 읽어라
	private String password; // custom.email.password
}
