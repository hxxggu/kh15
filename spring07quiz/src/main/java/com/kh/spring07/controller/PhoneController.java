package com.kh.spring07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring07.dao.PhoneDao;
import com.kh.spring07.dto.PhoneDto;
import com.kh.spring07.dto.PlayerDto;

@RestController
@RequestMapping("/phone")
public class PhoneController {
	@Autowired
	private PhoneDao phoneDao;
	
	@RequestMapping("/add") //등록
	public String insert(@ModelAttribute PhoneDto phoneDto) {
		phoneDao.insert(phoneDto);
		return "핸드폰 정보 등록 완료";
	}
	
	@RequestMapping("/list") //목록+검색
	public String list(
			@RequestParam(required=false) String column,
			@RequestParam(required=false) String keyword) {
		boolean search = column!=null && keyword!=null;
		List<PhoneDto> list = search ? 
				phoneDao.selectList(column, keyword) : phoneDao.selectList();
		StringBuffer bf = new StringBuffer();
		if(list.isEmpty()) bf.append("데이터가 존재하지 않습니다");
		else {
			bf.append("데이터 개수 : " + list.size() + "<br>");
			for(PhoneDto phoneDto : list) {
				bf.append(phoneDto.toString());
				bf.append("<br>");
			}
		} return bf.toString();
	}
	
	@RequestMapping("/detail") //상세
	public String detail(@RequestParam int phoneNo) {
		PhoneDto phoneDto = phoneDao.selectOne(phoneNo);
		if(phoneDto == null) return "존재하지 않는 핸드폰 번호";
		else return phoneDto.toString();
	}
	
	@RequestMapping("/edit") //수정
	public String edit(@ModelAttribute PhoneDto phoneDto) {
		boolean success = phoneDao.update(phoneDto);
		return success ? "핸드폰 정보 수정 완료" : "존재하지 않는 핸드폰 번호";
	}
	
	@RequestMapping("/delete") //삭제
	public String delete(@ModelAttribute PhoneDto phoneDto) {
		boolean success = phoneDao.update(phoneDto);
		return success ? "핸드폰 정보 삭제 완료" : "존재하지 않는 핸드폰 번호";
	}
}
