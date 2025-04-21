package com.kh.spring12.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.websocket.MemberMessageDao;
import com.kh.spring12.dto.websocket.MemberMessageDto;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.util.MemberMessageConverter;
import com.kh.spring12.vo.ClaimVO;
import com.kh.spring12.vo.websocket.MessageVO;

@CrossOrigin
@RestController
@RequestMapping("/api/member-message")
public class MemberMessageRestController {
	
	@Autowired
	private MemberMessageDao memberMessageDao;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private MemberMessageConverter memberMessageConverter;
	
	@GetMapping("/")
	public List<MessageVO> list(
			@RequestHeader(value = "Authorization", required = false) String bearerToken) {
		if(bearerToken == null) { // 비회원
			List<MemberMessageDto> list = 
					memberMessageDao.selectListForAnonymous();
			List<MessageVO> convertList = 
					memberMessageConverter.convertMessageFormat(list);
			return convertList;
		}
		else { // 회원
			ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
			List<MemberMessageDto> list = 
				memberMessageDao.selectListForMember(claimVO.getUserId());
			List<MessageVO> convertList = 
				memberMessageConverter.convertMessageFormat(list, claimVO.getUserId());
			return convertList;
		}
	}
	
}