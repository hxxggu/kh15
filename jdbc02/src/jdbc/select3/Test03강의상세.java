package jdbc.select3;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test03강의상세 {

	public static void main(String[] args) {
		int lectureNo = 3;
		
		LectureDao lectureDao = new LectureDao();
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto != null) {
			System.out.print("[No."+lectureDto.getLectureNo()+"] ");
			System.out.print(lectureDto.getLectureName());
			if(lectureDto.getLectureCategory() != null) {
				System.out.print("("+lectureDto.getLectureCategory()+")");
			}
			System.out.print(" / 기간:"+lectureDto.getLecturePeriod()+"개월");
			System.out.print(" / 가격:"+lectureDto.getLecturePrice()+"원");
			System.out.println(" ("+lectureDto.getLectureType()+")");
		} else System.out.println("존재하지 않는 강의 번호");

	}

}
