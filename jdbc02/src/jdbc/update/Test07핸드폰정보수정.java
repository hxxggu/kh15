package jdbc.update;

import jdbc.dao.PhoneDao;
import jdbc.dto.PhoneDto;

public class Test07핸드폰정보수정 {
	public static void main(String[] args) {
		PhoneDto phoneDto = new PhoneDto();
		phoneDto.setPhoneNo(10);
		phoneDto.setPhoneName("갤럭시 노트 10");
		phoneDto.setPhoneTelecom("LG");
		phoneDto.setPhonePrice(1500000);
		phoneDto.setPhoneContract(0);
		
		PhoneDao phoneDao = new PhoneDao();
		boolean success = phoneDao.update(phoneDto);
		
		if(success) System.out.println("수정완료");
		else System.out.println("대상이 없습니다");
	}
}
