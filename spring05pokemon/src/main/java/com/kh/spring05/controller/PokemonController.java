package com.kh.spring05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring05.dao.PokemonDao;
import com.kh.spring05.dto.PokemonDto;

@RestController
@RequestMapping("/pokemon") //공용주소
public class PokemonController {
	
	@Autowired
	private PokemonDao pokemonDao;
	
	//등록매핑
	@RequestMapping("/insert") //페이지 주소(상세 주소)
//	public String insert(
//			@RequestParam String pokemonName,
//			@RequestParam String pokemonType) {
	public String insert(@ModelAttribute PokemonDto pokemonDto) {
		pokemonDao.insert(pokemonDto);
		return "포켓몬 등록 완료";
	}
	
	//수정 매핑
	@RequestMapping("/update")
	public String update(@ModelAttribute PokemonDto pokemonDto) { //ModelAttribute: pokemonDto에 맞게 바꾸라는 명령
		boolean success = pokemonDao.update(pokemonDto);
		return success ? "포켓몬 변경 완료" : "존재하지 않는 포켓몬 번호";
	}
	
	//삭제 매핑
	@RequestMapping("/delete")
	public String delete(@RequestParam int pokemonNo) {
		boolean success = pokemonDao.delete(pokemonNo);
		return success ? "포켓몬 삭제 완료" : "존재하지 않는 포켓몬 번호";
	}
}
