package com.kh.spring08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspViewController {
	
	@RequestMapping("/jsp")
	public String test01() {
		return "/WEB-INF/views/test01.jsp";
	}
	
	@RequestMapping("/test02")
	public String test02() {
		return "/WEB-INF/views/test02.jsp";
	}
	
	@RequestMapping("/test03")
	public String test03() {
		return "/WEB-INF/views/test03.jsp";
	}
	
	@RequestMapping("/test07")
	public String test07() {
		return "/WEB-INF/views/test07.jsp";
	}
}
