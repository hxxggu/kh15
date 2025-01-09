package com.kh.spring09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class CountryContoller {
	@Autowired
	private CountryDao countryDao;
	
	//등록매핑 - 3개
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/country/add.jsp";
	}
	@PostMapping("/add")
	public String add(@ModelAttribute CountryDto countryDto) {
		countryDto.insert(countryDto);
		return "redirect:addFinish"; //상대경로
		//return "redirect:/country/addFinish"; //절대경로
	}
	@RequestMapping("/addFinish")
	public String addFinish() {
		return "
	}
	
	
	
}
