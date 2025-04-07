package com.kh.spring12.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 로그인 성공 시에 사용자(react)에게 전달해야 할 값을 필드로 작성
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountSignInResponseVO {
	private String userId;
	private String userLevel;
	private String accessToken; // 접근용 토큰 (시간이 짧을 수록 보안이 좋음, 보통 1-12시간 사이로 설정)
	private String refreshToken; // 갱신용 토큰 (시간이 길 수록 사용자가 편함, 보통 1달로 설정)
}