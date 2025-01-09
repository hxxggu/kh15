package com.kh.spring08.controller;
import java.time.LocalDate;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//model은 화면에 데이터를 실어 나르는 카트(컨트롤러에 선언하면 사용 가능)
	@RequestMapping("/test07")
	public String test07(Model model) {
		Random r = new Random();
		int dice = r.nextInt(6)+1;
//		model.addAttribute("이름", 값);
//		** map과 같은 모양을 갖고 있음 ** 
//		MVP(Model View P)의 궁극적인 목적: 계산과 디자인을 분리하기 위해서 > 한 페이지처럼 보이게 할 수 있음
		model.addAttribute("dice", dice);
		return "/WEB-INF/views/test07.jsp";
	}
	
	//Q. test08 매핑을 만들고
	//출생년도 4자리를 birth라는 이름으로 받아서 한국 나이를 구하여 출력
	
	@RequestMapping("/test08")
	public String test08(@RequestParam int birth, Model model) {
		int age = LocalDate.now().getYear()-birth+1;
		//return "당신의 나이 : " +age; //예전방식(화면 없을 때)
		model.addAttribute("age", age);
		return "/WEB-INF/views/test08.jsp";
	}
	
}
