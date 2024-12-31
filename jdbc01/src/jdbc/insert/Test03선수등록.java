package jdbc.insert;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import jdbc.util.JdbcFactory;

public class Test03선수등록 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("선수 이름 : ");
		String playerName = sc.next();
		System.out.print("종목 : ");
		String playerEvent = sc.next();
		System.out.print("동계/하계 : ");
		String playerType = sc.next();
		System.out.print("금메달 수 : ");
		int playerGold = sc.nextInt();
		System.out.print("은메달 수 : ");
		int playerSilver = sc.nextInt();
		System.out.print("동메달 수 : ");
		int playerBronze = sc.nextInt();
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
						
		String sql = "insert into player(player_no, player_name, player_event, player_type, player_gold_medal, player_silver_medal, player_bronze_medal) "
				+ "values(player_seq.nextval, ?, ?, ?, ?, ?, ?)";
		Object[] data = {playerName,playerEvent, playerType, playerGold, playerSilver, playerBronze};
		
		jdbcTemplate.update(sql, data);
		System.out.println("실행완료");
	}
}
