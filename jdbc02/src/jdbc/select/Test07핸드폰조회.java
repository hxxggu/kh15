package jdbc.select;

import java.util.List;

import jdbc.dao.PhoneDao;
import jdbc.dto.PhoneDto;

public class Test07핸드폰조회 {

	public static void main(String[] args) {
		PhoneDao phoneDao = new PhoneDao();
		List<PhoneDto> list = phoneDao.selectList();
		
		for(PhoneDto phoneDto : list) {
			System.out.print("["+phoneDto.getPhoneNo()+"]");
			System.out.print(phoneDto.getPhoneName());
			System.out.print(" / 통신사:"+phoneDto.getPhoneTelecom());
			System.out.print(" / 금액:"+phoneDto.getPhonePrice()+"원");
			if(phoneDto.getPhoneContract() > 0)
			System.out.println("(할부기간:"+phoneDto.getPhoneContract()+"개월)");
			else System.out.println("(할부없음)");
		}

	}

}