package com.kh.spring07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring07.dao.GameUserDao;
import com.kh.spring07.dto.GameUserDto;

@RestController
@RequestMapping("/game_user")
public class GameUserController {
	@Autowired
	private GameUserDao gameUserDao;
	
	@RequestMapping("/add") //등록
	public String insert(@ModelAttribute GameUserDto gameUserDto) {
		gameUserDao.insert(gameUserDto);
		return "유저 정보 등록 완료";
	}
	
	@RequestMapping("/list") //목록+검색
	public String list(
			@RequestParam(required=false) String column,
			@RequestParam(required=false) String keyword) {
		boolean search = column!=null && keyword!=null;
		List<GameUserDto> list = search ? 
				gameUserDao.selectList(column, keyword) : gameUserDao.selectList();
		StringBuffer bf = new StringBuffer();
		if(list.isEmpty()) bf.append("데이터가 존재하지 않습니다");
		else {
			bf.append("데이터 개수 : " + list.size() + "<br>");
			for(GameUserDto gameUserDto : list) {
				bf.append(gameUserDto.toString());
				bf.append("<br>");
			}
		} return bf.toString();
	}
	
	@RequestMapping("/detail") //상세
	public String detail(@RequestParam int gameUserNo) {
		GameUserDto gameUserDto = gameUserDao.selectOne(gameUserNo);
		if(gameUserDto == null) return "존재하지 않는 유저 번호";
		else return gameUserDto.toString();
	}
	
	@RequestMapping("/edit") //수정
	public String edit(@ModelAttribute GameUserDto gameUserDto) {
		boolean success = gameUserDao.update(gameUserDto);
		return success ? "유저 정보 수정 완료" : "존재하지 않는 유저 번호";
	}
	
	@RequestMapping("/delete") //삭제
	public String delete(@ModelAttribute GameUserDto gameUserDto) {
		boolean success = gameUserDao.update(gameUserDto);
		return success ? "유저 정보 삭제 완료" : "존재하지 않는 유저 번호";
	}

}
