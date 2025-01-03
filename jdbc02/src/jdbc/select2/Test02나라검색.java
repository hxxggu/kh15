package jdbc.select2;

import java.util.List;

import jdbc.dao.CountryDao;
import jdbc.dto.CountryDto;

public class Test02나라검색 {
	public static void main(String[] args) {
		String column = "이름"; //이름, 수도
		String keyword = "한국";
		
		CountryDao countryDao = new CountryDao();
		List<CountryDto> list = countryDao.selectList(column, keyword);
		
		for(CountryDto countryDto : list) {
			System.out.print("["+ countryDto.getCountryNo() +"]");
			System.out.print(countryDto.getCountryName());
			System.out.print("("+ countryDto.getCountryCapital() +")");
			System.out.println(" / 인구:" + countryDto.getCountryPopulation() + "명");
		}
	}
}
