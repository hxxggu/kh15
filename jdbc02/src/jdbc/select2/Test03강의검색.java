package jdbc.select2;

import java.util.List;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test03강의검색 {
	public static void main(String[] args) {
		String column = "강의타입"; //이름, 카테고리, 기간, 가격, 강의타입
		String keyword = "온라인";
		
		LectureDao lectureDao = new LectureDao();
		List<LectureDto> list = lectureDao.selectList(column, keyword);
		
		for(LectureDto lectureDto : list) {
			System.out.print("[No."+lectureDto.getLectureNo()+"] ");
			System.out.print(lectureDto.getLectureName());
			if(lectureDto.getLectureCategory() != null) {
				System.out.print("("+lectureDto.getLectureCategory()+")");
			}
			System.out.print(" / 기간:"+lectureDto.getLecturePeriod()+"개월");
			System.out.print(" / 가격:"+lectureDto.getLecturePrice()+"원");
			System.out.println(" ("+lectureDto.getLectureType()+")");
		}
	}
}
