package com.kh.spring12;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.dto.PokemonDto;

@SpringBootTest
public class Test02마이바티스등록 {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		// myBaits에서는 등록 시 DTO 객체를 전송하면 된다
		int pokemonNo = sqlSession.selectOne("pokemon.sequence");
		
		PokemonDto pokemonDto = new PokemonDto();
		pokemonDto.setPokemonNo(pokemonNo);
		pokemonDto.setPokemonName("별가사리");
		pokemonDto.setPokemonType("물");
		
		sqlSession.insert("pokemon.add2", pokemonDto);
		// jdbcTemplate.update(sql, data);
	}

}
