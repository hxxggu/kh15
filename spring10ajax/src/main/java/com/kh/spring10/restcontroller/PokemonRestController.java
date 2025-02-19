package com.kh.spring10.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.PokemonDao;

@CrossOrigin // public 같은 느낌으로 이해하면 좀더 쉬움
@RestController
@RequestMapping("/pokemon")
public class PokemonRestController {
	
	@Autowired
	private PokemonDao pokemonDao;
	
	// 포켓몬스터의 이름이 사용 중인지 알려주는 매핑
	@GetMapping("/check")
	public boolean check(@RequestParam String pokemonName) { // boolean : true/false 로 사용중의 유무를 판단
		//List<PokemonDto> list = pokemonDao.selectListByName(pokemonName);
		int count = pokemonDao.countByPokemonName(pokemonName);
		return count > 0;
	}
	
	
	
}
