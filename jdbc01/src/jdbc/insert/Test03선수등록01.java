package jdbc.insert;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import jdbc.util.JdbcFactory;

public class Test03선수등록01 {
	public static void main(String[] args) {
		String playerName = "피카츄";
		String playerEvent = "스키";
		String playerType = "동계";
		int playerGoldMedal = 3;
		int playerSilverMedal = 2;
		int playerBronzeMedal = 1; 
		
		//데이터베이스 처리
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		
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
