package com.kh.spring12.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 로그인 성공 시에 사용자(react)에게 전달해야 할 값을 필드로 작
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountSignInResponseVO {
	private String userId;
	private String userLevel;
}
