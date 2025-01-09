package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.dao.GameUserDao;
import com.kh.spring09.dto.GameUserDto;

@Controller
@RequestMapping("/game-user")
public class GameUserController {

	@Autowired
	private GameUserDao gameUserDao;
	
	//등록 매핑
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/game-user/add.jsp";
	}
	@PostMapping("/add")
	public String add(@ModelAttribute GameUserDto gameUserDto) {
		if(gameUserDto.getGameUserLevel() == 0) {
			gameUserDto.setGameUserLevel(1);
		}
		gameUserDao.insert(gameUserDto);
		return "redirect:add-finish";
	}
	@RequestMapping("/add-finish")
	public String addFinish() {
		return "/WEB-INF/views/game-user/add-finish.jsp";
	}
	
}