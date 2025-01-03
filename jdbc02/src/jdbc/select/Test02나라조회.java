package jdbc.select;

import java.util.List;

import jdbc.dao.CountryDao;
import jdbc.dto.CountryDto;

public class Test02나라조회 {
	public static void main(String[] args) {
		CountryDao countryDao = new CountryDao();
		List<CountryDto> list = countryDao.selectList();
		
		for(CountryDto countryDto : list) {
//			System.out.println(countryDto);
			System.out.print("[" + countryDto.getCountryNo() + "]");
			System.out.print(countryDto.getCountryName());
			System.out.print("(수도:" + countryDto.getCountryCapital()+")");
			System.out.print(" 인구:" + countryDto.getCountryPopulation());
		}
	}
}
