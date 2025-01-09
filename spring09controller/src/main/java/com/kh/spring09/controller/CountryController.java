package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.dao.CountryDao;
import com.kh.spring09.dto.CountryDto;

@Controller
@RequestMapping("/country")
public class CountryController {
	@Autowired
	private CountryDao countryDao;
	
	//등록 매핑 - 3개
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/country/add.jsp";
	}
	@PostMapping("/add")
	public String add(@ModelAttribute CountryDto countryDto) {
		countryDao.insert(countryDto);
		return "redirect:addFinish";//상대경로
		//return "redirect:/country/addFinish";//절대경로
	}
	@RequestMapping("/addFinish")
	public String addFinish() {
		return "/WEB-INF/views/country/addFinish.jsp";
	}
	
}