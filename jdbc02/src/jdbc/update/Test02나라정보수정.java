package jdbc.update;

import jdbc.dao.CountryDao;
import jdbc.dto.CountryDto;

public class Test02나라정보수정 {
	public static void main(String[] args) {
		CountryDto countryDto = new CountryDto();
		countryDto.setCountryNo(3);
		countryDto.setCountryName("변경된국가");
		countryDto.setCountryCapital("변경된수도");
		countryDto.setCountryPopulation(100000L);
		
		CountryDao countryDao = new CountryDao();
		boolean success = countryDao.update(countryDto);
		
		if(success) System.out.println("수정완료");
		else System.out.println("대상이 없습니다");
		
	}
}
