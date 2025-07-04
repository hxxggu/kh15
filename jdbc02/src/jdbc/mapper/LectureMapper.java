package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.LectureDto;

public class LectureMapper implements RowMapper<LectureDto>{

	@Override
	public LectureDto mapRow(ResultSet rs, int idx) throws SQLException {
		LectureDto lectureDto = new LectureDto();
		lectureDto.setLectureNo(rs.getInt("lecture_no"));
		lectureDto.setLectureName(rs.getString("lecture_name"));
		lectureDto.setLectureCategory(rs.getString("lecture_category"));
		lectureDto.setLecturePeriod(rs.getInt("lecture_period"));
		lectureDto.setLecturePrice(rs.getInt("lecture_price"));
		lectureDto.setLectureType(rs.getString("lecture_type"));
		
		return lectureDto;
	}
}