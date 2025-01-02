package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.GameUserDto;
import jdbc.util.JdbcFactory;

public class GameUserDao {

	//등록 메소드
	public void insert(GameUserDto gameUserDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "insert into game_user(game_user_no, game_user_id, game_user_job, game_user_level, game_user_money) "
				+ "values(game_user_seq.nextval, ?, ?, ?, ?)";
		Object[] data = {
			gameUserDto.getGameUserId(), gameUserDto.getGameUserJob(),
			gameUserDto.getGameUserLevel(), gameUserDto.getGameUserMoney()
		};
		jdbcTemplate.update(sql, data);
	}
	
	public boolean update(GameUserDto gameUserDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		
		String sql = "update game_user "
			+ "set game_user_id = ?, game_user_job = ?, game_user_level = ?, game_user_money = ? "
			+ "where game_user_no = ?";
		
		Object[] data = {
				gameUserDto.getGameUserId(),
				gameUserDto.getGameUserJob(),
				gameUserDto.getGameUserLevel(),
				gameUserDto.getGameUserMoney(),
				gameUserDto.getGameUserNo()
		};
		
		int rows = jdbcTemplate.update(sql, data);
		
		return rows > 0;
	}
	
	public boolean delete(int gameUserDao) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "delete lecture where lecture_no= ?";
		Object[] data = {gameUserDao};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
}