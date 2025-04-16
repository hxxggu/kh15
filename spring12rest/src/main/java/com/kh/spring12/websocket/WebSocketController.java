package com.kh.spring12.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
	웹소켓에서 메시지 수신 이후의 작업을 처리하기 위한 컨트롤러
	원래 웹소켓은 HTTP와 구조가 완전히 다르지만, 브로커의 도움으로 비슷한 구조
 */
@Slf4j
@Controller // 컨트롤러로 등록
//@RequestMapping("/app")
public class WebSocketController {
	
	// 원래대로라면
	// @RequestMapping("/chat") 처럼 작성해야 하지만 웹소켓은 다름
	@MessageMapping("/chat") // 이렇게 사용
	@SendTo("/public/chat") // 자동으로 반환된 내용이 전달되도록 처리
	public String chat(String message) {
		log.debug("메시지 도착 = {}", message);
		return message;
	} // 가장 간단한 STOMP의 컨트롤러 (=에코서버), 서버 통신의 기본
	
}
