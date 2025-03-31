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
	
	// 등록 (1) - 시퀀스 자동 생성
	public void insert(CountryDto countryDto) {
		sqlSession.insert("country.add", countryDto);
	}
	
	// 시퀀스 + 등록
	public int sequence() {
		return sqlSession.selectOne("country.sequence");
	}
	public void insert2(CountryDto countryDto) {
		sqlSession.insert("country.add2", countryDto);
	}
	
	// 삭제 메서드
	public boolean delete(int countryNo) {
		return sqlSession.delete("country.delete", countryNo) > 0;
	}
	
	// 수정 메서드
	public boolean update(CountryDto countryDto) {
		return sqlSession.update("country.edit", countryDto) > 0;
	}
	
	// 상세조회 메소드
	public CountryDto selectOne(int countryNo) {
		return sqlSession.selectOne("country.find", countryNo);
	}
	
//	
//	//국기 등록(연결)
//	public void connect(int countryNo, int attachmentNo) {
//		String sql = "insert into country_flag(country_no, attachment_no) values(?, ?)";
//		Object[] data = {countryNo, attachmentNo};
//		jdbcTemplate.update(sql, data);
//	}
//	public int findAttachment(int countryNo) {
//		String sql = "select attachment_no from country_flag "
//						+ "where country_no=?";
//		Object[] data = {countryNo};
//		return jdbcTemplate.queryForObject(sql, int.class, data);
//	}
}