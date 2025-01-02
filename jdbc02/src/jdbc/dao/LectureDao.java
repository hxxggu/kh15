package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.LectureDto;
import jdbc.util.JdbcFactory;

public class LectureDao {

	//등록 메소드
	public void insert(LectureDto lectureDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "insert into lecture(lecture_no, lecture_name, lecture_category, lecture_period, lecture_price, lecture_type) "
				+ "values(lecture_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] data = {
			lectureDto.getLectureName(), lectureDto.getLectureCategory(),
			lectureDto.getLecturePeriod(), lectureDto.getLecturePrice(),
			lectureDto.getLectureType()
		};
		jdbcTemplate.update(sql, data);
	}
	
}