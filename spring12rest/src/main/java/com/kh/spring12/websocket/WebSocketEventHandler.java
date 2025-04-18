package com.kh.spring12.websocket;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import com.kh.spring12.dao.AccountDao;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.ClaimVO;
import com.kh.spring12.vo.websocket.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WebSocketEventHandler {
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate; // 전송 도구
	@Autowired
	private TokenService tokenService;
	@Autowired
	private AccountDao accountDao;
	
	// 접속한 사용자들을 관리하기 위한 저장소를 생성
	private List<UserVO> users = new CopyOnWriteArrayList<>(); // 순서 유지
	// private Set<UserVO> users = new CopyOnWriteArraySet<>(); // 빠른 처리
	
	// 편리하게 만들기 위해 이름을 정해둠
	@EventListener
	public void whenUserEnter(SessionConnectEvent event) {
		// 헤더 정보를 추출
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
		String sessionId = accessor.getSessionId(); // 웹소켓 세션 ID
		String accessToken = accessor.getFirstNativeHeader("accessToken");
		
		log.debug("사용자 접속");
		log.debug("Session ID  = {}, AccessToken = {}", sessionId, accessToken);
		
		if(accessToken ==  null) return; // 비회원 차단
		
		ClaimVO claimVO = tokenService.parseBearerToken(accessToken);
		UserVO userVO = accountDao.selectOnePublicInfo(claimVO.getUserId());
		
		// 같은 사용자가 있으면 차단하세요 (해당 코드가 작동되기 위해서는 비교 기준 설정이 필요함)
		if(users.contains(userVO)) return;
		
		users.add(userVO); // 사용자 등록
		log.debug("현재 사용자 수 : {}명", users.size());
	}
	
	@EventListener
	public void whenUserSubscribe(SessionSubscribeEvent event) {
		log.debug("채널 구독 완료");
	}
	
	@EventListener
	public void whenUserLeave(SessionDisconnectEvent event) {
		log.debug("사용자 접속 완료");
	}

}
