package com.kh.spring04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon") //이 컨트롤러의 모든 매핑에 공용주소 부여
public class PokemonController {
	
	//여기에서 어떻게 JdbcTemplate을 쓴다는건가?
	//: 만드는건 안됨 (스프링을 쓸 필요가 없다)
	//: 만들어진 걸 달라고 해야함 (의존성 주입)
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/insert")
	public String insert(
			@RequestParam String pokemonName,
			@RequestParam String pokemonType) {
		String sql = "insert into pokemon(pokemon_no, pokemon_name, pokemon_type)values(pokemon_seq.nextval, ?, ?)";
		Object[] data = {pokemonName, pokemonType};
		jdbcTemplate.update(sql, data);
		return "포켓몬 등록 완료";
	}
}
