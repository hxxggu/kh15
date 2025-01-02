package jdbc.insert2;

public class Test05나라등록 {
	public static void main(String[] args) {
		
		CountryDto countryDto = new CountryDto();
		countryDto.setCountryName("영국");
		countryDto.setCountryCapital("런던");
		countryDto.setCountryPopulation(50000000);
		
		CountryDao countryDao = new CountryDao();
		countryDao.insert(countryDto);
		
		System.out.println("등록 완료");
		
	}
}