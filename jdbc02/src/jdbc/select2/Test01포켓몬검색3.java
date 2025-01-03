package jdbc.select2;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PokemonDto;
import jdbc.mapper.PokemonMapper;
import jdbc.util.JdbcFactory;

public class Test01포켓몬검색3 {
	public static void main(String[] args) throws Exception {
		//검색 가능한 항목을 미리 저장해두고 꺼내서 사용하도록 구현
		Map<String, String> example = Map.of(
			"이름", "pokemon_name",
			"속성", "pokemon_type"
		);
				
		//입력
//		String column = "이름";
		String column = "속성";
//		String keyword = "테스트";
		String keyword = "바람";
		
		String columnName = example.get(column);
		if(columnName == null) {
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
