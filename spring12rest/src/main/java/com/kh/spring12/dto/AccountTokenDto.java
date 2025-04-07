package com.kh.spring12.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountTokenDto { // 이메일 인증번호 전송 기능과 비슷한 기능
	private Long accountTokenNo;
	private String accountTokenTarget;
	private String accountTokenValue;
	private Timestamp accountTokenTime;
}
