package com.kh.spring09.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09.dao.GameUserDao;
import com.kh.spring09.dto.GameUserDto;
import com.kh.spring09.service.AttachmentService;

@Controller
@RequestMapping("/game-user")
public class GameUserController {

	@Autowired
	private GameUserDao gameUserDao;
	@Autowired
	private AttachmentService attachmentService;
	
	//등록 매핑
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/game-user/add.jsp";
	}
	//파일 첨부 기능 삽입 이전 코드
//	@PostMapping("/add")
//	public String add(@ModelAttribute GameUserDto gameUserDto) {
//		if(gameUserDto.getGameUserLevel() == 0) {
//			gameUserDto.setGameUserLevel(1);
//		}
//		gameUserDao.insert(gameUserDto);
//		return "redirect:addFinish";
//	}
	
	@PostMapping("/add")
	public String add(
			@ModelAttribute GameUserDto gameUserDto,
			@RequestParam MultipartFile attach
			) throws IllegalStateException, IOException {
		if(gameUserDto.getGameUserLevel() == 0) {
			gameUserDto.setGameUserLevel(1);
		}
		
		int gameUserNo = gameUserDao.sequence();
		gameUserDto.setGameUserNo(gameUserNo);
		gameUserDao.insert2(gameUserDto);
		
		if(attach.isEmpty() == false) {//첨부파일이 있으면
			int attachmentNo = attachmentService.save(attach);
			gameUserDao.connect(gameUserNo, attachmentNo);
		}
		return "redirect:addFinish";
	}
	
	@RequestMapping("/addFinish")
	public String addFinish() {
		return "/WEB-INF/views/game-user/addFinish.jsp";
	}
	
	//목록 및 검색 매핑
	@RequestMapping("/list")
	public String list(
			@RequestParam(required = false) String column,
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
	
	//삭제 매핑
	@RequestMapping("/delete")
	public String delete(@RequestParam int gameUserNo) {
		gameUserDao.delete(gameUserNo);
		return "redirect:list";//상대경로
		//return "redirect:/game-user/list";//절대경로
	}
	
	//수정 매핑
	@GetMapping("/edit")
	public String edit(@RequestParam int gameUserNo, Model model) {
		GameUserDto gameUserDto = gameUserDao.selectOne(gameUserNo);
		model.addAttribute("gameUserDto", gameUserDto);
		return "/WEB-INF/views/game-user/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute GameUserDto gameUserDto) {
		boolean success = gameUserDao.update(gameUserDto);
		if(success) {
			return "redirect:detail?gameUserNo="+gameUserDto.getGameUserNo();
		}
		else {
			return "redirect:list";
		}
	}
	
	//(+추가) 레벨업 매핑
	@RequestMapping("/levelup")
	public String levelup(@RequestParam int gameUserNo) {
		GameUserDto gameUserDto = gameUserDao.selectOne(gameUserNo);
		int level = gameUserDto.getGameUserLevel();
		gameUserDto.setGameUserLevel(level+1);
		gameUserDao.update(gameUserDto); //1.dto에서 레벨을 불러와 +1 해서 업데이트하는 방법
		//gameUserDao.increaseGameUserLevel(gameUserNo); //2.Dao에 메서드를 새로 추가하는 방법
		return "redirect:detail?gameUserNo = " +gameUserNo;
	}
	
	@RequestMapping("/profile")
	public String profile(@RequestParam int gameUserNo) {
		try {
			int attachmentNo = gameUserDao.findAttachment(gameUserNo);
			return "redirect:/attachment/download?attachmentNo="+attachmentNo;
		}
		catch(Exception e) {
			return "redirect:/images/empty.png";
		}
	}
	
}