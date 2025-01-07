package com.kh.spring06.controller;

import java.util.List;

import org.apache.tomcat.jni.Buffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//조회 매핑
	@RequestMapping("/list")
	public String list() {
		List<CountryDto> list = countryDao.selectList();
		StringBuffer bf = new StringBuffer();
		if(list.isEmpty()) {
			bf.append("데이터가 존재하지 않습니다");
		} else {
			bf.append("데이터 개수 : " + list.size() + "<br>");
			for(CountryDto countryDto : list) {
				bf.append(countryDto.toString());
				bf.append("<br>");
			}
		} return bf.toString();
	}
	
	//검색 매핑
	@RequestMapping("/search")
	public String search(
			@RequestParam String column,
			@RequestParam String keyword) {
		List<CountryDto> list = countryDao.selectList(column, keyword);
		StringBuffer bf = new StringBuffer();
		if(list.isEmpty()) {
			bf.append("데이터가 존재하지 않습니다");
		} else {
			bf.append("데이터 개수 : " + list.size() + "<br>");
			for(CountryDto countryDto : list) {
				bf.append(countryDto.toString());
				bf.append("<br>");
			}
		} return bf.toString();
	}

	
	//조회+검색 매핑
	@RequestMapping("/total")
	public String total(
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		//검색인지 판정
		boolean search = column!=null && keyword!=null;
		List<CountryDto> list = search ? countryDao.selectList(column, keyword) : countryDao.selectList();
		StringBuffer bf = new StringBuffer();
		if(list.isEmpty()) {
			bf.append("데이터가 존재하지 않습니다");
		} else {
			bf.append("데이터 개수 : " + list.size() + "<br>");
			for(CountryDto countryDto : list) {
				bf.append(countryDto.toString());
				bf.append("<br>");
			}
		} return bf.toString();
	}
}