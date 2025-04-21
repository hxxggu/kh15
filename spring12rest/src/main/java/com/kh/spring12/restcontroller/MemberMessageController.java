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
import com.kh.spring12.vo.ClaimVO;

@CrossOrigin
@RestController
@RequestMapping("/api/member-message")
public class MemberMessageController {
	
	@Autowired
	private MemberMessageDao memberMessageDao;
	@Autowired
	private TokenService tokenService;
	
	@GetMapping("/")
	public List<MemberMessageDto> list(
			@RequestHeader(value = "Authorization", required = false) String bearerToken) {
		if(bearerToken == null) {//비회원
			return memberMessageDao.selectListForAnonymous();
		}
		else {//회원
			ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
			return memberMessageDao.selectListForMember(claimVO.getUserId());
		}
	}
	
}