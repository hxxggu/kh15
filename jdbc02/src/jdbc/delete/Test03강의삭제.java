package jdbc.delete;

import jdbc.dao.LectureDao;

public class Test03강의삭제 {
	public static void main(String[] args) {
		
		int lectureNo = 20;
		
		LectureDao lectureDao = new LectureDao();
		boolean success = lectureDao.delete(lectureNo);
		
		if(success) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("존재하지 않는 강의 번호");
		}
	}
}