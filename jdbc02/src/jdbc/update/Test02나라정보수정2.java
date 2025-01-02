package jdbc.update;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcFactory;

public class Test02나라정보수정2 {
	public static void main(String[] args) {
		
		int countryNo = 1;
		String countryName = "테스트국가";
		String countryCapital = "테스트도시";
		long countryPopulation = 10000000L;
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		
		String sql = "update country "
				+ "set country_name = ?, country_capital = ?, country_capital = ? "
				+ "where country_no = ?";
		Object[] data = {
				countryName, countryCapital, countryPopulation, countryNo
		};
		int rows = jdbcTemplate.update(sql, data);
		
		if(rows > 0) System.out.println("수정완료");
		else System.out.println("대상이 없습니다");
	}
}
