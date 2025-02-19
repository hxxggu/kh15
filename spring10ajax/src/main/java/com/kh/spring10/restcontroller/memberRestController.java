package com.kh.spring10.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.MemberDao;
import com.kh.spring10.dto.MemberDto;


@CrossOrigin
@RestController
@RequestMapping("/member")
public class memberRestController {
	
	@Autowired
	private MemberDao memberDao;
	
	
	@PostMapping("/check/memberId")
	public boolean checkMemberId(@RequestParam String memberId) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		return memberDto != null;
	}
	
	@PostMapping("/check/memberNickname")
	public boolean checkMemberNickname(@RequestParam String memberNickname) {
		MemberDto memberDto = memberDao.selectOneByMemberNickname(memberNickname);
//		int count = memberDao.countByMemberNickname(memberNickname);
		return memberDto != null;
	}
}
