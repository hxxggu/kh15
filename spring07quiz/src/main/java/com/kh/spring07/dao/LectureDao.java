package com.kh.spring07.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring07.dto.LectureDto;
import com.kh.spring07.mapper.LectureMapper;
@Repository
public class LectureDao {
	@Autowired
	private LectureMapper lectureMapper;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(LectureDto lectureDto) {
		String sql = "insert into lecture(lecture_no, lecture_name, "
				+ "lecture_category, lecture_period, lecture_price, lecture_type) "
				+ "values(lecture_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] data = {
			lectureDto.getLectureName(), lectureDto.getLectureCategory(),
			lectureDto.getLecturePeriod(), lectureDto.getLecturePrice(),
			lectureDto.getLectureType()
		};
		jdbcTemplate.update(sql, data);
	}
	
	public boolean update(LectureDto lectureDto) {
		String sql = "update lecture "
				+ "set lecture_name = ?, lecture_category = ?, "
				+ "lecture_period = ?, lecture_price = ?, lecture_type = ? "
				+ "where lecture_no = ?";
		Object[] data = {
				lectureDto.getLectureName(),
				lectureDto.getLectureCategory(),
				lectureDto.getLecturePeriod(),
				lectureDto.getLecturePrice(),
				lectureDto.getLectureType(),
				lectureDto.getLectureNo()
		};
		int rows = jdbcTemplate.update(sql, data);
		return rows > 0;
	}
	
	public boolean delete(int lectureNo) {
		String sql = "delete lecture where lecture_no= ?";
		Object[] data = {lectureNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	public List<LectureDto> selectList() {
		String sql = "select * from lecture";
		return jdbcTemplate.query(sql, lectureMapper);
	}

	private Map<String, String> columnExample = Map.of(
			"이름", "lecture_name",
			"카테고리", "lecture_category",
			"기간", "lecture_period",
			"가격", "lecture_price",
			"강의타입", "lecture_type"
			);
	
	public List<LectureDto> selectList(String column, String keyword){
		String columnName = columnExample.get(column);
		if(columnName == null) throw new RuntimeException("항목 오류");
		String sql = "select * from lecture "
				+ "where instr(" + columnName + ", ? ) > 0 "
				+ "order by " + columnName + " asc, lecture_no asc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, lectureMapper, data);
	}
	
	public LectureDto selectOne(int lectureNo) {
		String sql = "select * from lecture where lecture_no = ?";
		Object[] data = {lectureNo};
		List<LectureDto> list = jdbcTemplate.query(sql, lectureMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}	
}