package com.kh.spring08.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

//@RestController //글자를 결과로 내보내는 컨트롤러
@Controller //화면을 결과로 내보내는 컨트롤러
@RequestMapping("/legacy")
public class LegacyViewController {
	
	@RequestMapping("/test1")
	public void test1(HttpServletResponse response) throws IOException {
		//컨트롤러에서도 화면을 만들 수 있다(비추천)
		//response는 사용자에게 내보낼 내용이 담긴 인스턴스
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("<h1>Hello</h1>");
	}
}
