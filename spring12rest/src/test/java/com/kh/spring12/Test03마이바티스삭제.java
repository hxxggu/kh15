package com.kh.spring12;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.dto.PokemonDto;

@SpringBootTest
public class Test03마이바티스삭제 {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void delete() {
		int pokemonNo = 67;
		
		int count = sqlSession.delete("pokemon.delete", pokemonNo);
		System.out.println("count = " + count);
	}

}
