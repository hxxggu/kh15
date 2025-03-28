package com.kh.spring12.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.CountryDto;
import com.kh.spring12.mapper.CountryMapper;

@Repository
public class CountryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private CountryMapper countryMapper;

	// 등록 메소드
	public void insert(CountryDto countryDto) {
		String sql = "insert into country(country_no, country_name, country_capital, country_population) "
				+ "values(country_seq.nextval, ?, ?, ?)";
		Object[] data = { countryDto.getCountryName(), countryDto.getCountryCapital(),
				countryDto.getCountryPopulation() };
		jdbcTemplate.update(sql, data);
	}
	// 시퀀스생성+등록 메소드
	public int sequence() {
		String sql = "select country_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insert2(CountryDto countryDto) {
		String sql = "insert into country(country_no, country_name, country_capital, country_population) "
				+ "values(?, ?, ?, ?)";
		Object[] data = { 
				countryDto.getCountryNo(), 
				countryDto.getCountryName(), 
				countryDto.getCountryCapital(),
				countryDto.getCountryPopulation() 
		};
		jdbcTemplate.update(sql, data);
	}

	// 수정 메소드
	public boolean update(CountryDto countryDto) {
		String sql = "update country " + "set country_name=?, country_capital=?, country_population=? "
				+ "where country_no = ?";
		Object[] data = {
				countryDto.getCountryName(),
				countryDto.getCountryCapital(),
				countryDto.getCountryPopulation(),
				countryDto.getCountryNo()
		};
		int rows = jdbcTemplate.update(sql, data);
		return rows > 0;
	}

	// 삭제 메소드
	public boolean delete(int countryNo) {
		String sql = "delete country where country_no = ?";
		Object[] data = { countryNo };
		return jdbcTemplate.update(sql, data) > 0;
	}

	// 조회 메소드
	public List<CountryDto> selectList() {
		String sql = "select * from country order by country_no asc";
		return jdbcTemplate.query(sql, countryMapper);
	}

	// 검색 항목을 설정
	private Map<String, String> columnExamples = Map.of("국가명", "country_name", "수도명", "country_capital");

	// 검색 메소드
	public List<CountryDto> selectList(String column, String keyword) {
		// 컬럼 변환
		String columnName = columnExamples.get(column);
		if (columnName == null) {
			throw new RuntimeException("항목 오류");
		}

		String sql = "select * from country " + "where instr(#1, ?) > 0 " + "order by #1 asc, country_no asc";
		sql = sql.replace("#1", columnName);
		Object[] data = { keyword };
		// return jdbcTemplate.query(sql, data, countryMapper);
		return jdbcTemplate.query(sql, countryMapper, data);
	}

	// 상세조회 메소드
	public CountryDto selectOne(int countryNo) {
		String sql = "select * from country where country_no = ?";
		Object[] data = { countryNo };
		List<CountryDto> list = jdbcTemplate.query(sql, countryMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	//국기 등록(연결)
	public void connect(int countryNo, int attachmentNo) {
		String sql = "insert into country_flag(country_no, attachment_no) values(?, ?)";
		Object[] data = {countryNo, attachmentNo};
		jdbcTemplate.update(sql, data);
	}
	public int findAttachment(int countryNo) {
		String sql = "select attachment_no from country_flag "
						+ "where country_no=?";
		Object[] data = {countryNo};
		return jdbcTemplate.queryForObject(sql, int.class, data);
	}
}