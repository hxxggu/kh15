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
	
	//목록 및 검색 매핑
	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String column,
							@RequestParam(required = false) String keyword,
							Model model) {
		boolean search = column != null && keyword != null;
		if(search) {
			model.addAttribute("list", gameUserDao.selectList(column, keyword));
		}
		else {
			model.addAttribute("list", gameUserDao.selectList());
		}
		model.addAttribute("search", search);
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);
		return "/WEB-INF/views/game-user/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int gameUserNo, Model model) {
		GameUserDto gameUserDto = gameUserDao.selectOne(gameUserNo);
		model.addAttribute("gameUserDto", gameUserDto);
		return "/WEB-INF/views/game-user/detail.jsp";
	}
	
}