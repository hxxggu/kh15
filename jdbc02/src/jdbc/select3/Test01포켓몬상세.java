package jdbc.select3;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PokemonDto;
import jdbc.mapper.PokemonMapper;
import jdbc.util.JdbcFactory;

public class Test01포켓몬상세 {

	public static void main(String[] args) {
		//상세조회
		//: 원하는 대상 1개만 조회하기 위한 작업
		//: 기본키(PK) 조건을 사용
		//: (문제)목록/검색처럼 Mapper를 쓰면 List가 나온다
		//: Mapper를 사용한다면 List의 맨 앞에 데이터를 추출해야 한다
		
		int pokemonNo = 1;
		
		PokemonMapper pokemonMapper = new PokemonMapper();
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from pokemon where pokemon_no = ?";
		Object[] data = {pokemonNo};
		List<PokemonDto> list = jdbcTemplate.query(sql, pokemonMapper, data); 
		
//		PokemonDto pokemonDto;
//		if(list.size() == 0) {
//			pokemonDto = null;
//		} else {
//			pokemonDto = list.get(0);
//		}
//		PokemonDto pokemonDto = list.size() == 0 ? null : list.get(0);
		PokemonDto pokemonDto = list.isEmpty() ? null : list.get(0);
		
		if(pokemonDto == null) {
			System.out.println("존재하지 않는 포켓몬 번호");
		} else {
			System.out.println(pokemonDto);
		}
		
	}

}
