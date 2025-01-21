package com.kh.spring09.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.PokemonDto;
import com.kh.spring09.mapper.PokemonMapper;

//Dao는 영속성 항목을 제어하는 도구
//: 영속성이라는건 파일이나 데이터베이스처럼 놔두면 영원히 유지되는 것을 의미
//: 영속성 항목을 제어하는 도구들은 @Repository로 등록
@Repository
public class PokemonDao {
	//여기서 필요로 하는 도구들을 등록된 도구 중에서 가지고 온다(DI)
	@Autowired
	private PokemonMapper pokemonMapper;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(PokemonDto pokemonDto) {
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
	
	//시퀀스+등록
	public int sequence() {
		String sql = "select pokemon_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insert2(PokemonDto pokemonDto) {
		String sql = "insert into pokemon("
						+ "pokemon_no, pokemon_name, pokemon_type"
					+ ") "
					+ "values(pokemon_seq.nextval, ?, ?)";
			Object[] data = {
					pokemonDto.getPokemonNo(),
					pokemonDto.getPokemonName(),
					pokemonDto.getPokemonType()
			};
	}
	
	//수정 메서드
	public boolean update(PokemonDto pokemonDto) {
		String sql = "update pokemon "
				+"set pokemon_name = ?, pokemon_type =? "
				+"where pokemon_no = ?";
		Object[] data = {
				pokemonDto.getPokemonName(),
				pokemonDto.getPokemonType(),
				pokemonDto.getPokemonNo()
		};
		int rows = jdbcTemplate.update(sql, data);
		return rows > 0;
	}
	
	//삭제 메서드
	public boolean delete(int pokemonNo) {
		String sql = "delete pokemon where pokemon_no = ?";
		Object[] data = {pokemonNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
			
	public List<PokemonDto> selectList(){
		String sql = "select * from pokemon";
		return jdbcTemplate.query(sql, pokemonMapper);
	}
	
	//검색 항목을 설정
	private Map<String, String> columnExample = Map.of(
		"이름", "pokemon_name",
		"속성", "pokemon_type"
		);
	
	//검색 메서드
	public List<PokemonDto> selectList(String column, String keyword){
		String columnName = columnExample.get(column);
		if(columnName == null) {
			throw new RuntimeException("항목 오류");
		}
		
		String sql = "select * from pokemon "
				+ "where instr("+ columnName +", ?) > 0 "
				+ "order by "+ columnName +" asc, pokemon_no asc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, pokemonMapper, data);			
	}
	
	public PokemonDto selectOne(int pokemonNo) {
		String sql = "select * from pokemon where pokemon_no = ?";
		Object[] data = {pokemonNo};
		List<PokemonDto> list = jdbcTemplate.query(sql, pokemonMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	//포켓몬 이미지 등록(연결)
	public void connect(int pokemonNo, int attachmentNo){
		String sql = "insert into pokemon_image ("
					+ "pokemon_no, attachment_no"
				+ ") values(?, ?)";
		Object[] data = {pokemonNo, attachmentNo};
		jdbcTemplate.update(sql, data);
	}
	
	//포켓몬 이미지 찾기
	//-반환형이 int 이기 때문에 만약 이미지가 없으면 에외가 발생함
	public int findAttachment(int pokemonNo) {
		String sql = "select attachment_no from pokemon_image "
				+ "where pokemon_no = ?";
		Object[] data = {pokemonNo};
		return jdbcTemplate.queryForObject(sql, int.class, data);
	}	
}