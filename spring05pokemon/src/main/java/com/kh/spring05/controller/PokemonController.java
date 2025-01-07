package com.kh.spring05.controller;

import java.nio.Buffer;
import java.util.List;

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
	
	//목록 매핑
	@RequestMapping("/list")
	public String list() {
		List<PokemonDto> list = pokemonDao.selectList();
		 StringBuffer bf = new StringBuffer();
//		 StringBuffer : 느리지만 여러 명이 접속했을 때 안정적
//		 StringBuilder : 빠르지만 여러 명이 접속했을 때 불안정
//		웹 들어오기 전 구성한 코드
//		for(PokemonDto pokemonDto : list) {
//			System.out.println(pokemonDto);
//		}
		 for(PokemonDto pokemonDto : list) {
			 bf.append(pokemonDto.toString());
			 bf.append("<br>");
		 }
		 return bf.toString();
	}
		
	//검색 매핑
	//: column, keyword 라는 항목을 전달받아 유사한 항목을 검색
	@RequestMapping("/search")
	public String search(
			@RequestParam String column,
			@RequestParam String keyword) {
		List<PokemonDto> list = pokemonDao.selectList(column, keyword); 
		StringBuffer bf = new StringBuffer();
		bf.append("검색 결과 수 : " +list.size() + "<br>");
		for(PokemonDto pokemonDto : list) {
			bf.append(pokemonDto.toString());
			bf.append("<br>");
		}
		return bf.toString();
	}
	
	//상세 매핑
	@RequestMapping("/detail")
	public String detail(@RequestParam int pokemonNo) {
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		if(pokemonDto == null) {
			return "존재하지 않는 포켓몬 번호";
		} else {
			return pokemonDto.toString();
		}
	}
	
}
