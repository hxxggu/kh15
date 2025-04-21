package com.kh.spring12.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kh.spring12.dto.websocket.MemberMessageDto;
import com.kh.spring12.vo.websocket.MemberChatResponseVO;
import com.kh.spring12.vo.websocket.MessageVO;
import com.kh.spring12.vo.websocket.SystemMessageVO;

@Component
public class MemberMessageConverter {
	
	//	public List<SystemMessageVO> convertMessageFormat(List<MemberMessageDto> list) {
	//	public List<MemberChatResponseVO> convertMessageFormat(List<MemberMessageDto> list) {
	
	// 비회원용 메세지 변환 메소드 (SystemMessageVO , MemberChatResponseVO)
	public List<MessageVO> convertMessageFormat(List<MemberMessageDto> list) {
		List<MessageVO> convertList = new ArrayList<>();
		
		// 모든 메세지를 반복하며 형태에 맞는 메세지로 바꿔서 저장
		for(MemberMessageDto memberMessageDto : list) {
			switch(memberMessageDto.getMemberMessageType()) {
			case "CHAT":
				convertList.add(MemberChatResponseVO.builder()
					.accountId(memberMessageDto.getMemberMessageSender())
					.accountLevel(null)
					.accountNickname(null)
					.type("CHAT")
					.content(memberMessageDto.getMemberMessageContent())
					.time(memberMessageDto.getMemberMessageTime().toLocalDateTime())
				.build());
				break;
			case "SYSTEM":
				convertList.add(SystemMessageVO.builder()
					.type("SYSTEM")
					.content(memberMessageDto.getMemberMessageContent())
					.time(memberMessageDto.getMemberMessageTime().toLocalDateTime())
				.build());
				break;
			}
		}
		
		return convertList;
	}
	
	// 회원용 메세지 변환 ( DM-SEND / DM-RECEIVE / CHAT / SYSTEM )
	public List<MessageVO> convertMessageFormat(List<MemberMessageDto> list, String userId) {	
		List<MessageVO> convertList = new ArrayList<>();
		
		// 모든 메세지를 반복하며 형태에 맞는 메세지로 바꿔서 저장
		for(MemberMessageDto memberMessageDto : list) {
			switch(memberMessageDto.getMemberMessageType()) {
			case "DM": // DM-SEND, DM-RECEIVE
				// 내 아이디가 작성자와 같다면 = 내가 보낸 DM이라면
				if(userId.equals(memberMessageDto.getMemberMessageSender())) {
					convertList.add(MemberChatResponseVO.builder()
						.type("DM-SEND")
						.accountId(memberMessageDto.getMemberMessageReceiver())
						.accountNickname(null)
						.accountLevel(null)
						.content(memberMessageDto.getMemberMessageContent())
						.time(memberMessageDto.getMemberMessageTime().toLocalDateTime())
					.build());
				}
				// 내 아이디가 수신자와 같다면 = 내가 받은 DM이라면
				else if(userId.equals(memberMessageDto.getMemberMessageReceiver())){
					convertList.add(MemberChatResponseVO.builder()
						.type("DM-RECEIVE")
						.accountId(memberMessageDto.getMemberMessageSender())
						.accountNickname(null)
						.accountLevel(null)
						.content(memberMessageDto.getMemberMessageContent())
						.time(memberMessageDto.getMemberMessageTime().toLocalDateTime())
					.build());
				}
				break;
			case "CHAT":
				convertList.add(MemberChatResponseVO.builder()
					.accountId(memberMessageDto.getMemberMessageSender())
					.accountLevel(null)
					.accountNickname(null)
					.type("CHAT")
					.content(memberMessageDto.getMemberMessageContent())
					.time(memberMessageDto.getMemberMessageTime().toLocalDateTime())
				.build());
				break;
			case "SYSTEM":
				convertList.add(SystemMessageVO.builder()
					.type("SYSTEM")
					.content(memberMessageDto.getMemberMessageContent())
					.time(memberMessageDto.getMemberMessageTime().toLocalDateTime())
				.build());
				break;
			}
		}
		
		return convertList;
	}
}