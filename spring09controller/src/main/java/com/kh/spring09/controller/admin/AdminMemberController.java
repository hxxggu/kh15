package com.kh.spring09.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.MemberDto;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
	@Autowired
	private MemberDao memberDao;
	
	//회원 목록 및 검색
	@RequestMapping("/list")
	public String list(
			@RequestParam(required=false) String column,
			@RequestParam(required=false) String keyword,
			Model model) {
		boolean search = column!=null && keyword!=null;
		if(search) {
			model.addAttribute("list", memberDao.selectList(column, keyword));
		} else {
			model.addAttribute("list", memberDao.selectList());
		}
		model.addAttribute("search", search);
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);
		return "/WEB-INF/views/admin/member/list.jsp";
	}
	
	//회원 상세정보
	@RequestMapping("/detail")
	public String detail(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");
		
		
		return "/WEB-INF/views/admin/member/detail.jsp";
	}
	
	//회원 정보 수정
	@GetMapping("/edit")
	public String edit() {
		
	}
	@PostMapping("/edit")
	public String edit(
			@ModelAttribute MemberDto memberDto,
			HttpSession session) {
		
	}
	
	
}
