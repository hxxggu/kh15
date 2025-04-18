package com.kh.spring12.vo.websocket;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// 사용자에게 공개될 유저의 정보
@Data @Builder @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "accountId") // accountId가 같으면 같은 인스턴스 취급하라 (기준 설정)
public class UserVO {
	private String accountId;
	private String accountNickname;
	private String accountLevel;
	private Timestamp accountJoin;
}
