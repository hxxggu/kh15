package com.kh.spring07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring07.dao.MenuDao;
import com.kh.spring07.dto.MenuDto;


@RestController
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuDao menuDao;
	
	@RequestMapping("/add") //등록
	public String insert(@ModelAttribute MenuDto menuDto) {
		menuDao.insert(menuDto);
		return "메뉴 정보 등록 완료";
	}
	
	@RequestMapping("/list") //목록+검색
	public String list(
			@RequestParam(required=false) String column,
			@RequestParam(required=false) String keyword) {
		boolean search = column!=null && keyword!=null;
		List<MenuDto> list = search ?
				menuDao.selectList(column, keyword) : menuDao.selectList();
		StringBuffer bf = new StringBuffer();
		if(list.isEmpty()) bf.append("데이터가 존재하지 않습니다");
		else {
			bf.append("데이터 개수 : " + list.size() + "<br>");
			for(MenuDto menuDto : list) {
				bf.append(menuDto.toString());
				bf.append("<br>");
			}
		} return bf.toString();
	}
	
	@RequestMapping("/detail") //상세
	public String detail(@RequestParam int menuNo) {
		MenuDto menuDto = menuDao.selectOne(menuNo);
		if(menuDto == null) return "존재하지 않는 메뉴 번호";
		else return menuDto.toString();
	}
	
	@RequestMapping("/edit") //수정
	public String edit(@ModelAttribute MenuDto menuDto) {
		boolean success = menuDao.update(menuDto);
		return success ? "메뉴 정보 수정 완료" : "존재하지 않는 메뉴 번호";
	}
	
	@RequestMapping("/delete") //삭제
	public String delete(@ModelAttribute MenuDto menuDto) {
		boolean success = menuDao.update(menuDto);
		return success ? "메뉴 정보 삭제 완료" : "존재하지 않는 메뉴 번호";
	}
	
}
