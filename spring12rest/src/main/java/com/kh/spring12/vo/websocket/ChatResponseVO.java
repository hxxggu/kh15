package com.kh.spring12.vo.websocket;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
// @EqualsAndHashCode(callSuper = false) : class로 만들면 이게 필요
public class ChatResponseVO implements MessageVO {
	private String content;
	private LocalDateTime time;
}
