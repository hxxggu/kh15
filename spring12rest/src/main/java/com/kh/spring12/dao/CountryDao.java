package com.kh.spring12.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.CountryDto;

@Repository
public class CountryDao {

	@Autowired
	private SqlSession sqlSession;

	// 목록
	public List<CountryDto> selectList() {
		return sqlSession.selectList("country.list");
	}
	
	// 등록 메서드
	public void insert(CountryDto countryDto) {
		sqlSession.insert("country.add", countryDto);
	}
	
	// 시퀀스 생성 + 등록 메서드
	public long sequence() {
		return sqlSession.selectOne("country.sequence");
	}
	public void insert2(CountryDto countryDto) {
		sqlSession.insert("country.add2", countryDto);
	}
	
	// 수정 메서드
	public boolean update(CountryDto countryDto) {
		return sqlSession.update("country.edit", countryDto) > 0; // PUT
	}
	// 수정 메서드 (* 일부 수정)
	public boolean updateUnit(CountryDto countryDto) {
		// 해당 Dto는 항상 차있지 않을 수도 있음
		return sqlSession.update("country.editUnit", countryDto) > 0; // PATCH
	}
	
	// 삭제 메서드
	public boolean delete(long countryNo) {
		return sqlSession.delete("country.delete", countryNo) > 0;
	}
		
	// 상세조회 메소드
	public CountryDto selectOne(long countryNo) {
		return sqlSession.selectOne("country.find", countryNo);
	}
	
//	
//	//국기 등록(연결)
//	public void connect(long countryNo, long attachmentNo) {
//		String sql = "insert into country_flag(country_no, attachment_no) values(?, ?)";
//		Object[] data = {countryNo, attachmentNo};
//		jdbcTemplate.update(sql, data);
//	}
//	public long findAttachment(long countryNo) {
//		String sql = "select attachment_no from country_flag "
//						+ "where country_no=?";
//		Object[] data = {countryNo};
//		return jdbcTemplate.queryForObject(sql, int.class, data);
//	}
}