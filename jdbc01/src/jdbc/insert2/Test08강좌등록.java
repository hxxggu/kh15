package jdbc.insert2;

public class Test08강좌등록 {
	public static void main(String[] args) {
		
		LectureDto lectureDto = new LectureDto();
		lectureDto.setLectureName("연애초보탈출");
		lectureDto.setLectureCategory("라이프스타일");
		lectureDto.setLecturePrice(1000000);
		lectureDto.setLecturePeriod(120);
		lectureDto.setLectureType("오프라인");
		
		LectureDao lectureDao = new LectureDao();
		lectureDao.insert(lectureDto);
		
		System.out.println("등록 완료");
		
	}
}