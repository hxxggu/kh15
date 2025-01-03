package jdbc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.CountryDto;
import jdbc.mapper.CountryMapper;
import jdbc.util.JdbcFactory;

public class CountryDao {

	//등록 메서드
	public void insert(CountryDto countryDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "insert into country(country_no, country_name, "
				+ "country_capital, country_population) "
				+"values(country_seq.nextval, ?, ?, ?)";
		
		Object[] data = {
			countryDto.getCountryName(),
			countryDto.getCountryCapital(),
			countryDto.getCountryPopulation()
		};
		jdbcTemplate.update(sql, data);
	}
	
	//수정 메서드
	public boolean update(CountryDto countryDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "update country "
				+ "set country_name = ?, country_capital = ?, country_population = ? "
				+ "where country_no = ?";
				
		Object[] data = {
				countryDto.getCountryName(),
				countryDto.getCountryCapital(),
				countryDto.getCountryPopulation(),
				countryDto.getCountryNo()
		};
		int rows  = jdbcTemplate.update(sql, data);
		return rows > 0;
	}
	
	//삭제 메서드
	public boolean delete(int countryNo) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "delete country where country_no = ?";
		Object[] data = {countryNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	private CountryMapper countryMapper = new CountryMapper();
	
	public List<CountryDto> selectList(){
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from country";
		return jdbcTemplate.query(sql, countryMapper);
	}
	
	//검색 항목을 설정
	private Map<String, String> columnExample = Map.of(
		"국가명", "country_name",
		"수도명", "country_capital"
		);
	
	//검색 메서드
	public List<CountryDto> selectList(String column, String keyword){
		//컬럼 변환
		String columnName =  columnExample.get(column);
		if(columnName == null) {
			throw new RuntimeException("항목 오류");
		}
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from country "
				+ "where instr(#1, ?) > 0 "
				+ "order by #1 asc, country_no asc";
		sql = sql.replace("#1", columnName);		
//		String sql = "select * from country "
//				+ "where instr(" +columnName + ", ?) > 0 "
//				+ "order by " + columnName + " asc, country_no asc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, countryMapper, data);
	}
}