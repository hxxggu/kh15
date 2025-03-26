package com.kh.spring12.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.PokemonDao;
import com.kh.spring12.dto.PokemonDto;

@CrossOrigin
@RestController
@RequestMapping("/api/pokemon")
public class PokemonRestController {
	@Autowired
	private PokemonDao pokemonDao;
	
	// @RequestMapping은 이제 사용하지 않는다
	// 작업에 맞게 주소를 최소화하여 사용한다 (자원 기반 주소 방식, ROA)
	// - 주소가 같아도 방식이 다르면 다른 작업을 시킬 수 있다
	// - 방식이 몇 가지가 있을까? 작업은 몇 종류가 있을까?
	// - 작업은 C, R, U, D 네 가지가 있다
	// - Get, Post, Put, Delete 방식을 각각의 작업에 연결하여 사용
	// - 조회(GET), 삭제(DELETE), 등록(POST), 수정(PUT-전체수정 / PATCH-부분수정)
	// - 주소에 기능은 가급적 배제하고 Entity 만 기술
	
	
	@GetMapping("/list")
	public List<PokemonDto> list() {
		return pokemonDao.selectList();
	}
}
