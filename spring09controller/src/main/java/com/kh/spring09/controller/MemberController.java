package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.MemberDto;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	
	//회원가입 매핑
	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
		return "redirect:join-finish";
	}
	@RequestMapping("/join-finish") //주소에는 대문자를 잘 쓰지 않음. 쓸 수 있는 경우가 있고, 없는 경우가 있음.
	public String joinFinish() {
		return "/WEB-INF/views/member/join-finish.jsp";
	}
	
	//로그인 매핑
	@GetMapping("/login")
	public String login() {
		return  "/WEB-INF/views/member/login.jsp";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto) {
		MemberDto findDto = memberDao.selectOne(memberDto.getMemberId());
		//아이디가 없으면 findDto는 null이다
		if(findDto == null) { //아이디 없음
			return "redirect:login"; //로그인 페이지로 쫓아낸다
		} //아이디가 있으면 비밀번호 검사를 진행
		boolean isValid = findDto.getMemberPw().equals(memberDto.getMemberPw());
		if(isValid) { //로그인 성공 시
			return "redirect:/";
			
		} else { //비밀번호 다름
			return "redirect:login"; //로그인페이지로 쫓아낸다
		}
	}
}
