package jdbc.update;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test05강의정보수정 {
	public static void main(String[] args) {
		LectureDto lectureDto = new LectureDto();
		lectureDto.setLectureNo(2);
		lectureDto.setLectureName("자바 개발자 과정");
		lectureDto.setLectureCategory("IT");
		lectureDto.setLecturePeriod(3);
		lectureDto.setLecturePrice(200000);
		lectureDto.setLectureType("온라인");
		
		LectureDao lectureDao = new LectureDao();
		boolean success = lectureDao.update(lectureDto);
		
		if(success) System.out.println("수정완료");
		else System.out.println("대상이 없습니다");
	}
}
