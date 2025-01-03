package jdbc.select3;

import jdbc.dao.CountryDao;
import jdbc.dto.CountryDto;

public class Test02나라상세 {

	public static void main(String[] args) {
		int countryNo = 1;
		
		CountryDao countryDao = new CountryDao();
		CountryDto countryDto  = countryDao.selectOne(countryNo);
		
		if(countryDto != null) {
			System.out.print("["+ countryDto.getCountryNo() +"]");
			System.out.print(countryDto.getCountryName());
			System.out.print("("+ countryDto.getCountryCapital() +")");
			System.out.println(" / 인구:" + countryDto.getCountryPopulation() + "명");
		} else System.out.println("존재하지 않는 나라 번호");
	}
}