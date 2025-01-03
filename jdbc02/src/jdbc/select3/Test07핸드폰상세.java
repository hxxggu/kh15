package jdbc.select3;

import jdbc.dao.PhoneDao;
import jdbc.dto.PhoneDto;

public class Test07핸드폰상세 {

	public static void main(String[] args) {
		int phoneNo = 2;
		
		PhoneDao phoneDao = new PhoneDao();
		PhoneDto phoneDto = phoneDao.selectOne(phoneNo);
		
		if(phoneDto != null) {
			System.out.print("["+phoneDto.getPhoneNo()+"]");
			System.out.print(phoneDto.getPhoneName());
			System.out.print(" / 통신사:"+phoneDto.getPhoneTelecom());
			System.out.print(" / 금액:"+phoneDto.getPhonePrice()+"원");
			if(phoneDto.getPhoneContract() > 0)
			System.out.println("(할부기간:"+phoneDto.getPhoneContract()+"개월)");
			else System.out.println("(할부없음)");
		} else System.out.println("존재하지 않는 핸드폰 번호");
	}

}
