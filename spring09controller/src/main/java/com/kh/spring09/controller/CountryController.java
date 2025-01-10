package com.kh.spring09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.CountryDao;
import com.kh.spring09.dto.CountryDto;
import com.kh.spring09.dto.PokemonDto;

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
	
	//목록+검색 매핑
	@RequestMapping("/list")
	public String list(
			@RequestParam(required=false) String column,
			@RequestParam(required=false) String keyword,
			Model model) {
		boolean search = column!=null && keyword!=null;
		List<CountryDto> list;
		if(search) {
			list = countryDao.selectList(column, keyword);
		} else {
			list = countryDao.selectList();
		}
		
		model.addAttribute("search", search);
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/country/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int countryNo, Model model) {
		CountryDto countryDto = countryDao.selectOne(countryNo);
		model.addAttribute("countryDto", countryDto);
		return "/WEB-INF/views/country/detail.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int countryNo) {
		countryDao.delete(countryNo);
		return "redirect:list"; //redirect : 주소가 바뀜, 끝나고 다른 곳으로 이동(다른 주소로 보냄), 잦지 않은 특별한 작업(따로 표시를 해주야 함)
//		return "/WEB-INF/views/country /list.jsp"; //forward : 주소가 유지되고 화면만 연결, 보통의 일반적인 작업
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int countryNo, Model model) {
		CountryDto countryDto = countryDao.selectOne(countryNo);
		model.addAttribute("countryDto", countryDto);
		return "/WEB-INF/views/country/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute CountryDto countryDto) {
		boolean success = countryDao.update(countryDto);
		if(success) {
			return "redirect:detail?countryNo=" + countryDto.getCountryNo();
		} else {
			return "redirect:list";
		}
	}
}