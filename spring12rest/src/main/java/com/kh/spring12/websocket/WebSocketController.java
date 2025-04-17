package com.kh.spring12.websocket;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.kh.spring12.vo.websocket.ChatResponseVO;
import com.kh.spring12.vo.websocket.ChatVO;

import lombok.extern.slf4j.Slf4j;

/**
	웹소켓에서 메시지 수신 이후의 작업을 처리하기 위한 컨트롤러
	원래 웹소켓은 HTTP와 구조가 완전히 다르지만, 브로커의 도움으로 비슷한 구조
 */
@Slf4j
@Controller // 컨트롤러로 등록
//@RequestMapping("/app")
public class WebSocketController {
	
//	// ** 원래대로라면
//	// @RequestMapping("/chat") 처럼 작성해야 하지만 웹소켓은 다름
//	@MessageMapping("/chat") // 이렇게 사용
//	@SendTo("/public/chat") // 자동으로 반환된 내용이 전달되도록 처리
//	public String chat(String message) {
//		log.debug("메시지 도착 = {}", message);
//		return message;
//	} // 가장 간단한 STOMP의 컨트롤러 (=에코서버), 서버 통신의 기본
	
	// 조금 더 복잡한 처리를 하고 싶다면 수동으로 메시지를 전송하도록 해야 한다
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	// 메시지 수신을 좀더 체계적인 형태인 Message<?>로 수신
	// * 장점 : STOMP의 헤더와 바디를 각각 읽어서 처리할 수 있음 (인증 등에 유리함)
	// * 단점 : 새롭고 어려움
	@MessageMapping("/chat") // 사용자가 /app/chat 으로 보내면...
	public void chat(Message<ChatVO> message) { // import 유의할 것 (import org.springframework.messaging.Message;)
		ChatVO body = message.getPayload();
		log.debug("payload = {}", body);
		
		// ChatVO → ChatResponseVO 변환
		String content = body.getContent().replaceAll("(시발|개새끼|존나)", "****"); 
		
		ChatResponseVO response = ChatResponseVO.builder()
					.content(body.getContent()) // 수신한 내용
					.time(LocalDateTime.now()) // 현재 시각
				.build();
		
		// 수동으로 메시지를 전송하는 코드
		// messagingTemplate.convertAndSend("채널명", 데이터);
		messagingTemplate.convertAndSend("/public/chat", response);
		
	}
	
}
