package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PlayerDto;
import jdbc.util.JdbcFactory;

public class PlayerDao {
	public void insert(PlayerDto playerDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		
		String sql = "insert into player(player_no, player_name,"
				+ "player_event, player_type, player_gold_medal,"
				+ "player_silver medal, player_bronze_medal)"
				+ "values(player_seq.nextval, ?, ?, ?, ?, ?, ?)" ;
		
		Object[] data = {
				playerDto.getPlayerName(),
				playerDto.getPlayerEvent(),
				playerDto.getPleyerType(),
				playerDto.getPlayerGoldMedal(),
				playerDto.getPlayerSilverMedal(),
				playerDto.getPlayerBronzeMedal()
		};
	
		jdbcTemplate.update(sql, data);		
	}
	//수정 메서드
		public boolean update(PlayerDto playerDto) {
			JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
			String sql = "update player "
					+ "set player_name = ?, player_event = ?, player_type = ?, "
					+ "player_gold_medal = ?, player_silver medal = ?, "
					+ "player_bronze_medal = ? where player_no = ?";
			Object[] data = {
					playerDto.getPlayerName(),
					playerDto.getPlayerEvent(),
					playerDto.getPleyerType(),
					playerDto.getPlayerGoldMedal(),
					playerDto.getPlayerSilverMedal(),
					playerDto.getPlayerBronzeMedal(),
					playerDto.getPlayerNo()
			};

			return jdbcTemplate.update(sql, data) > 0;			
//			int rows = jdbcTemplate.update(sql, data);
//			return rows > 0;

		}
}