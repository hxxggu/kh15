package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.PokemonDto;

//데이터베이스에서 조회한 Pokemon에 대한 변환을 수행하는 도구
public class PokemonMapper implements RowMapper<PokemonDto> {

	@Override
	public PokemonDto mapRow(ResultSet rs, int idx) throws SQLException { //ResultSet == rs
		//한 줄을 PokemonDto로 바꾸어 반환하는 코드
		PokemonDto pokemonDto = new PokemonDto();
		pokemonDto.setPokemonNo(rs.getInt("pokemon_no")); //조회결과의 pokemon_no항목
		//조회결과(rs)에서 pokemon_no 항목을 찾아 dto에 설정하세요
		pokemonDto.setPokemonName(rs.getString("pokemon_name")); //조회 결과의 pokemon_name 항목
		pokemonDto.setPokemonType(rs.getString("pokemon_type")); //조회 결과의 pokemon_type 항목
		
		return pokemonDto;
	}
}
