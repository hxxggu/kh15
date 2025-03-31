package com.kh.spring12;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.dto.PokemonDto;

@SpringBootTest
public class Test04마이바티스수정 {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void edit() {
		PokemonDto pokemonDto = new PokemonDto();
		pokemonDto.setPokemonNo(6);
		pokemonDto.setPokemonName("이름바꾼 포켓몬");
		pokemonDto.setPokemonType("전기");
		
		int count = sqlSession.update("pokemon.edit", pokemonDto);
		System.out.println("count = " + count);
	}

}
