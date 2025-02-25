package com.kh.spring09.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix ="custom.cert")
public class CertProperties {
	private int expireMinutes; // custom.cert.expire-minutes 를 읽어와라
	private int expireAccept;
	//	** 자바는 무조건 카멜 케이스
}
