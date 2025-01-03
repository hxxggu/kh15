package jdbc.select2;

import java.util.List;

import jdbc.dao.PhoneDao;
import jdbc.dto.PhoneDto;

public class Test07핸드폰검색 {

	public static void main(String[] args) {
		String column = "통신사";
		String keyword = "알뜰폰";
		
		PhoneDao phoneDao = new PhoneDao();
		List<PhoneDto> list = phoneDao.selectList(column, keyword);
		
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
