package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PokemonDto;
import jdbc.util.JdbcFactory;

//DAO(Data Access Object)
//- DB의 특정 테이블에 대한 작업을 메소드별로 보관하는 클래스
public class PokemonDao {
	//등록 메소드(비추천)
	public void insert(String pokemonName, String pokemonType) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "insert into pokemon("
							+ "pokemon_no, pokemon_name, pokemon_type"
						+ ") "
						+ "values(pokemon_seq.nextval, ?, ?)";
		Object[] data = {pokemonName, pokemonType};
		jdbcTemplate.update(sql, data);
	}

	//객체지향스러운 등록 메소드(추천)
	public void insert(PokemonDto pokemonDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "insert into pokemon("
							+ "pokemon_no, pokemon_name, pokemon_type"
						+ ") "
						+ "values(pokemon_seq.nextval, ?, ?)";
		Object[] data = {
			pokemonDto.getPokemonName(),
			pokemonDto.getPokemonType()
		};
		jdbcTemplate.update(sql, data);
	}
}