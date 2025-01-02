package jdbc.insert2;

public class Test06휴대폰등록 {
	public static void main(String[] args) {
		
		PhoneDto phoneDto = new PhoneDto();
		phoneDto.setPhoneName("갤럭시25");
		phoneDto.setPhoneTelecom("KT");
		phoneDto.setPhonePrice(5000000);
		phoneDto.setPhoneContract(36);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.insert(phoneDto);
		
		System.out.println("등록 완료");
		
	}
}