package com.kh.spring12.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.websocket.MemberMessageDao;
import com.kh.spring12.dto.websocket.MemberMessageViewDto;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.util.MemberMessageConverter;
import com.kh.spring12.vo.ClaimVO;
import com.kh.spring12.vo.websocket.MessageVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
			List<MemberMessageViewDto> list = memberMessageDao.selectListForAnonymousByPaging();
			List<MessageVO> convertList = memberMessageConverter.convertMessageFormat(list);
			
			int count = memberMessageDao.countForAnonymousByPaging();
			boolean last = count == list.size();
			log.debug("last = {}", last);
			
			return convertList;
			
		} else { // 회원
			ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
			List<MemberMessageViewDto> list = memberMessageDao.selectListForMemberByPaging(claimVO.getUserId());
			List<MessageVO> convertList = memberMessageConverter.convertMessageFormat(list, claimVO.getUserId());
			
			int count = memberMessageDao.countForMemberByPaging(claimVO.getUserId());
			boolean last = count == list.size();
			log.debug("last = {}", last);
			
			return convertList;
		}
	}
	
	@GetMapping("/{memberMessageNo}")
	public List<MessageVO> listMore(
			@RequestHeader(value = "Authorization", required = false) String bearerToken,
			@PathVariable long memberMessageNo) {
		if(bearerToken == null) { // 비회원
			List<MemberMessageViewDto> list = memberMessageDao.selectListForAnonymousByPaging(memberMessageNo);
			List<MessageVO> convertList = memberMessageConverter.convertMessageFormat(list);
			
			int count = memberMessageDao.countForAnonymousByPaging(memberMessageNo);
			boolean last = count == list.size();
			log.debug("last = {}", last);
			
			return convertList;
			
		} else { // 회원
			ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
			List<MemberMessageViewDto> list = memberMessageDao.selectListForMemberByPaging(claimVO.getUserId(), memberMessageNo);
			List<MessageVO> convertList = memberMessageConverter.convertMessageFormat(list, claimVO.getUserId());
			
			int count = memberMessageDao.countForMemberByPaging(claimVO.getUserId(), memberMessageNo);
			boolean last = count == list.size();
			log.debug("last = {}", last);
			
			return convertList;
		}
	}
	
}