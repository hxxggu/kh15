package com.kh.spring12.vo.websocket;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class MessageListVO { // 단순 포장용 클래스, 둘을 같이 보관하기 위한 VO
	private boolean last;
	private List<MessageVO> list;
}
