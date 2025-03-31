package com.kh.spring12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.dto.PokemonDto;

@SpringBootTest
public class Test05마이바티스검색 {
	
	@Autowired
	private SqlSession sqlSession;

	@Test
	public void test() {
		// * 중요 : myBatis는 데이터를 한 개만 전달 할 수 있다
		// session과 형태가 비슷함
		Map<String, Object> param = new HashMap<>();
		param.put("column","pokemon_name");
		param.put("keyword", "피카");
		
//		List<PokemonDto> list = sqlSession.selectList("pokemon.search", param);
		// myBatis에서는 무조건 하나의 데이터만 넘길 수 있음
		List<PokemonDto> list = sqlSession.selectList("pokemon.listOrSearch", param);
		System.out.println("결과 수 : " + list.size());
		for(PokemonDto pokemonDto : list) { 
			System.out.println(pokemonDto);
		}
	}

}
