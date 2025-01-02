package jdbc.delete;

import jdbc.dao.PhoneDao;

public class Test07핸드폰삭제 {

	public static void main(String[] args) {
		
		int phoneNo = 4;
		
		PhoneDao phoneDao = new PhoneDao();
		boolean success = phoneDao.delete(phoneNo);
		
		if(success) System.out.println("삭제 완료");
		else System.out.println("존재하지 않는 핸드폰 번호");
	}

}
