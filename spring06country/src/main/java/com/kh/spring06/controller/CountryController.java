package com.kh.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.CountryDao;
import com.kh.spring06.dto.CountryDto;

@RestController
@RequestMapping("/country")
public class CountryController {
	@Autowired
	private CountryDao countryDao;
	
	@RequestMapping("/add")
	public String insert(@ModelAttribute CountryDto countryDto) {
		countryDao.insert(countryDto);
		return "국가 정보 등록 완료";
	}
	
	@RequestMapping("/edit")
	public String update(@ModelAttribute CountryDto countryDto) {
		boolean success = countryDao.update(countryDto);
		return success ? "국가 정보 수정 완료" : "존재하지 않는 국가 번호";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute CountryDto countryDto) {
		boolean success = countryDao.update(countryDto);
		return success ? "국가 정보 삭제 완료" : "존재하지 않는 국가 번호";
	}
	
	
}
