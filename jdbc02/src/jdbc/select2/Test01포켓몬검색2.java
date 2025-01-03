package jdbc.select2;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PokemonDto;
import jdbc.mapper.PokemonMapper;
import jdbc.util.JdbcFactory;

public class Test01포켓몬검색2 {
	public static void main(String[] args) throws Exception {
		
		//입력
		//column 속성
//		String column = "이름";
		String column = "속성";
		//keyword 검색값
//		String keyword = "테스트";
		String keyword = "바람";
		
		//column에 의해 검색해야하는 항목만 구해낼 수 있다면 구문을 통일
		//String columnName = "pokemon_name" or "pokemon_type";
		String columnName;
		switch(column) {
		case "이름" : columnName = "pokemon_name"; break;
		case "속성" : columnName = "pokemon_type"; break;
		default : //나머지는 예외 상황(원치 않는 상황)
			throw new Exception("지원하지 않는 검색 항목");
		}
		
		//처리
		PokemonMapper pokemonMapper = new PokemonMapper();
		
		if(column.equals("이름")) {
			JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
			String sql = "select * from pokemon "
					+ "where instr("+ columnName +", ?) > 0 "
					+ "order by "+ columnName +" asc, pokemon_no asc";
			Object[] data = {keyword};
			List<PokemonDto> list = jdbcTemplate.query(sql, pokemonMapper, data);
			for(PokemonDto pokemonDto : list) {
				System.out.println(pokemonDto);
			}
		}
		else if(column.equals("속성")) {
			JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
			String sql = "select * from pokemon "
					+ "where instr(pokemon_type, ?) > 0 "
					+ "order by pokemon_type asc, pokemon_no asc";
			Object[] data = {keyword};
			List<PokemonDto> list = jdbcTemplate.query(sql, pokemonMapper, data);
			for(PokemonDto pokemonDto : list) {
				System.out.println(pokemonDto);
			}
		}
	}
}
