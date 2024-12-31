package jdbc.insert;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test02나라등록 {
	public static void main(String[] args) {		
		
		//연결 정보 준비
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh15");
		dataSource.setPassword("kh15");
		
		//연결 도구 준비
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		String sql = "insert into country(country_no, country_name, country_capital)"
				+ "values(country_seq.nextval, '한국', '서울')";
		
		
		//실행 요청
		jdbcTemplate.update(sql);
		System.out.println("실행완료");
		
		
	}
}
