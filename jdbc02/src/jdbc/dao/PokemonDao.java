package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PokemonDto;
import jdbc.util.JdbcFactory;

//DAO(Data Access Object)
//- DB의 특정 테이블에 대한 작업을 메소드별로 보관하는 클래스
public class PokemonDao {
	//등록 메서드(비추천)
	public void insert(String pokemonName, String pokemonType) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "insert into pokemon("
							+ "pokemon_no, pokemon_name, pokemon_type"
						+ ") "
						+ "values(pokemon_seq.nextval, ?, ?)";
		Object[] data = {pokemonName, pokemonType};
		jdbcTemplate.update(sql, data);
	}

	//객체지향스러운 등록 메서드(추천)
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

	//수정 메서드
	public boolean update(PokemonDto pokemonDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "update pokemon "
				+"set pokemon_name = ?, pokemon_type =? "
				+"where pokemon_no = ?";
		
		Object[] data = {
				pokemonDto.getPokemonName(),
				pokemonDto.getPokemonType(),
				pokemonDto.getPokemonNo()
		};
		int rows = jdbcTemplate.update(sql, data);
		
//		if(rows > 0) return true; //수정이 성공했을 때(rows가 0보다 큼)
//		else return false; //수정이 실패했을 때(rows가 0 혹은 0보다 작음)
		//rows가 0보다 크면 true를 반환하고 아니면 false를 반환하시오
		
		return rows > 0;
	}
}