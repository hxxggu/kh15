package com.kh.spring12.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.GameUserDao;
import com.kh.spring12.dto.GameUserDto;
import com.kh.spring12.error.TargetNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/api/gameUser")
public class GameUserRestController {
	@Autowired
	private GameUserDao gameUserDao;
	
	// 조회
	@GetMapping("/")
	public List<GameUserDto> list() {
		return gameUserDao.selectList();
	}
	
	// 추가
	@PostMapping("/")
	public void insert(@RequestBody GameUserDto gameUserDto) {
		int sequence = gameUserDao.sequence();
		gameUserDto.setGameUserNo(sequence);
		gameUserDao.insert2(gameUserDto);
	}
	
	// 삭제
	@DeleteMapping("/{gameUserNo}")
	public void delete(@PathVariable int gameUserNo) {
		GameUserDto gameUserDto = gameUserDao.selectOne(gameUserNo);
		if(gameUserDto == null) throw new TargetNotFoundException();
		gameUserDao.delete(gameUserNo);
	}
	
	// 수정
	@PutMapping("/{gameUserNo}")
	public void edit(@PathVariable int gameUserNo,
			@RequestBody GameUserDto gameUserDto) {
		GameUserDto targetDto = gameUserDao.selectOne(gameUserNo);
		if(targetDto == null) throw new TargetNotFoundException();
		
		gameUserDto.setGameUserNo(gameUserNo);
		gameUserDao.update(gameUserDto);
	}
}
