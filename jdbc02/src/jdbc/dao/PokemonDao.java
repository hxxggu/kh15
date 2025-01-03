package jdbc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PokemonDto;
import jdbc.mapper.PokemonMapper;
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
	
	//삭제 메서드
	public boolean delete(int pokemonNo) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "delete pokemon where pokemon_no = ?";
		Object[] data = {pokemonNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//조회를 위한 Mapper를 필드로 선언
	private PokemonMapper pokemonMapper = new PokemonMapper();
	
	//목록조회 메서드
	public List<PokemonDto> selectList(){
		JdbcTemplate jdbcTemplate =JdbcFactory.createTemplate();
		String sql = "select * from pokemon";
		return jdbcTemplate.query(sql, pokemonMapper);
	}
	
	//검색에 사용할 컬럼에 대한 정보를 저장
	private Map<String, String> columnExample = Map.of(
		"이름", "pokemon_name",
		"속성", "pokemon_type"
		);
	
	//검색 메서드
	public List<PokemonDto> selectList(String column, String keyword){ //같은 이름으로 다시 선언하는 것 / 메서드 오버로딩, 오버라이딩 구분하기
		String columnName = columnExample.get(column); //컬럼명 획득(없으면
		if(columnName == null) {
			//return null; //없다고 말해주겠다
			//return List.of(); //결과가 비어있다고 말해주겠다
			throw new RuntimeException("항목 오류"); //너는 문제가 있다고 말해주겠다	//RuntimeExeption : 따로 예외에 대한 선언을 하지 않아도 됨
		}
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from pokemon "
				+ "where instr("+ columnName +", ?) > 0 " //"+: 구문의 일부", "holder : 데이터"를 의미
				+ "order by "+ columnName +" asc, pokemon_no asc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, pokemonMapper, data);			
	}
	
	//상세조회 메서드
	public PokemonDto selectOne(int pokemonNo) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from pokemon where pokemon_no = ?";
		Object[] data = {pokemonNo};
		List<PokemonDto> list = jdbcTemplate.query(sql, pokemonMapper, data);
		return list.isEmpty() ? null : list.get(0); //순서에 유의할 것
	}
	
	
	
	
	
	
}