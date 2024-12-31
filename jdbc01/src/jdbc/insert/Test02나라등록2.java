package jdbc.insert;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test02나라등록2 {
	public static void main(String[] args) {		
	
		
		//JDBC를 통해서 하고 싶은 제일 중요한 것
		//: 기존에 배웠던 자바의 입력과 데이터베이스 등록을 연결하는 것
		String countryName = "싱가폴";
		String countryCapital = "싱가폴";
		
		
		//연결 정보 준비
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh15");
		dataSource.setPassword("kh15");
		
		//연결 도구 준비
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		String sql = "insert into country(country_no, country_name, country_capital)"
				+ "values(country_seq.nextval, ?, ?)";
//		Object[] data = new Object[]{countryName, countryCapital};
		Object[] data = {countryName, countryCapital};
		
			
		//실행 요청
		jdbcTemplate.update(sql, data);
		System.out.println("실행완료");
		
	}
}