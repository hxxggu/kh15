package jdbc.insert;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test03선수등록00 {
	public static void main(String[] args) {
		String playerName = "피카츄";
		String playerEvent = "스키";
		String playerType = "동계";
		int playerGoldMedal = 3;
		int playerSilverMedal = 2;
		int playerBronzeMedal = 1; 
		
		//데이터베이스 처리
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh15");
		dataSource.setPassword("kh15");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "insert into player("
				+ "player_no, player_name, plyer_event, player_type,"
				+ "player_gold_medal, player_silver_medal,"
				+ "player_bronze_medal"
				+ ")"
				+ "values(player_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
	Object[] data = {
			playerName, playerEvent, playerType,
			playerGoldMedal, playerSilverMedal, playerBronzeMedal
	};
	
	//실행 요청
	jdbcTemplate.update(sql, data);
	System.out.println("실행완료");
	
	
	}
}
