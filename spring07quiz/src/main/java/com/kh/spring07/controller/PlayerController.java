package com.kh.spring07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring07.dao.PlayerDao;
import com.kh.spring07.dto.PlayerDto;

@RestController
@RequestMapping("/player")
public class PlayerController {
	@Autowired
	private PlayerDao playerDao;
	
	@RequestMapping("/add") //등록
	public String insert(@ModelAttribute PlayerDto playerDto) {
		playerDao.insert(playerDto);
		return "선수 정보 등록 완료";
	}
	
	@RequestMapping("/list") //목록+검색
	public String list(
			@RequestParam(required=false) String column,
			@RequestParam(required=false) String keyword) {
		boolean search = column!=null && keyword!=null;
		List<PlayerDto> list = search ? 
				playerDao.selectList(column, keyword) : playerDao.selectList();
		StringBuffer bf = new StringBuffer();
		if(list.isEmpty()) bf.append("데이터가 존재하지 않습니다");
		else {
			bf.append("데이터 개수 : " + list.size() + "<br>");
			for(PlayerDto playerDto : list) {
				bf.append(playerDto.toString());
				bf.append("<br>");
			}
		} return bf.toString();
	}
	
	@RequestMapping("/detail") //상세
	public String detail(@RequestParam int playerNo) {
		PlayerDto playerDto = playerDao.selectOne(playerNo);
		if(playerDto == null) return "존재하지 않는 선수 번호";
		else return playerDto.toString();
	}
	
	@RequestMapping("/edit") //수정
	public String edit(@ModelAttribute PlayerDto playerDto) {
		boolean success = playerDao.update(playerDto);
		return success ? "선수 정보 수정 완료" : "존재하지 않는 선수 번호";
	}
	
	@RequestMapping("/delete") //삭제
	public String delete(@ModelAttribute PlayerDto playerDto) {
		boolean success = playerDao.update(playerDto);
		return success ? "선수 정보 삭제 완료" : "존재하지 않는 선수 번호";
	}
}
