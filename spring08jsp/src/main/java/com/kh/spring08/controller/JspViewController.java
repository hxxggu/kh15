package com.kh.spring08.controller;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring08.dto.PokemonDto;

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
	
	@RequestMapping("/test04")
	public String test04() {
		return "/WEB-INF/views/test04.jsp";
	}
	
	@RequestMapping("/test05")
	public String test05() {
		return "/WEB-INF/views/test05.jsp";
	}
	
	@RequestMapping("/test06")
	public String test06() {
		return "/WEB-INF/views/test06.jsp";
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
	
	//Model에 int나 String 말고 인스턴스를 추가하여 전달할 수 있을까?
	@RequestMapping("/test09")
	public String test09(Model model) {
		LocalDate time = LocalDate.now();
		model.addAttribute("time", time);
		return "/WEB-INF/views/test09.jsp";
	}
	
	//DTO도 Model로 전달할 수 있을까?
	@RequestMapping("/test10")
	public String test10(Model model) {
		PokemonDto pokemonDto = new PokemonDto();
		pokemonDto.setPokemonNo(1);
		pokemonDto.setPokemonName("피카츄");
		pokemonDto.setPokemonType("전기");
//		model.addAttribute(pokemonDto); //자동으로 클래스 이름 첫글자만 소문자로 변환
		model.addAttribute("pokemonDto", pokemonDto); //수동으로 이름 부여
		return "/WEB-INF/views/test10.jsp";
	}
	
	//List를 Model에 전달할 수 있을까?
	@RequestMapping("/test11")
	public String test11(Model model) {
		List<PokemonDto> list = List.of(
				new PokemonDto(1, "피카츄", "전기"),
				new PokemonDto(2, "라이츄", "전기"),
				new PokemonDto(3, "파이리", "불"),
				new PokemonDto(4, "꼬부기", "물"),
				new PokemonDto(5, "버터플", "바람")
				);
		model.addAttribute("list", list);
		return "/WEB-INF/views/test11.jsp";
	}
	
	@RequestMapping("/test12")
	public String test12() {
		return "/WEB-INF/views/test12.jsp";
	}
	
	@RequestMapping("/test13")
	public String test13() {
		return "/WEB-INF/views/test13.jsp";
	}
	
	@RequestMapping("/test14")
	public String test14() {
		return "/WEB-INF/views/test14.jsp";
	}
}
