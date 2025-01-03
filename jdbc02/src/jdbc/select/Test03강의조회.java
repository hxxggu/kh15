package jdbc.select;

import java.util.List;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test03강의조회 {

	public static void main(String[] args) {
		LectureDao lectureDao = new LectureDao();
		List<LectureDto> list = lectureDao.selectList();
		
		for(LectureDto lectureDto : list) {
			System.out.print("[No."+lectureDto.getLectureNo()+"] ");
			System.out.print(lectureDto.getLectureName());
			if(lectureDto.getLectureCategory()!=null) {
				System.out.print("("+lectureDto.getLectureCategory()+")");
			}
			System.out.print(" / 기간:"+lectureDto.getLecturePeriod()+"개월");
			System.out.print(" / 가격:"+lectureDto.getLecturePrice()+"원");
			System.out.println(" ("+lectureDto.getLectureType()+")");
		}

	}

}
