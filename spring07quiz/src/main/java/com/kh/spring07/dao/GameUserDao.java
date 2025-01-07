package com.kh.spring07.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring07.dto.GameUserDto;
import com.kh.spring07.mapper.GameUserMapper;
@Repository
public class GameUserDao {
	@Autowired
	private GameUserMapper gameUserMapper;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(GameUserDto gameUserDto) {
		String sql = "insert into game_user(game_user_no, game_user_id, game_user_job, game_user_level, game_user_money) "
				+ "values(game_user_seq.nextval, ?, ?, ?, ?)";
		Object[] data = {
			gameUserDto.getGameUserId(), gameUserDto.getGameUserJob(),
			gameUserDto.getGameUserLevel(), gameUserDto.getGameUserMoney()
		};
		jdbcTemplate.update(sql, data);
	}
	
	public boolean update(GameUserDto gameUserDto) {
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
		String sql = "delete lecture where lecture_no= ?";
		Object[] data = {gameUserDao};
		return jdbcTemplate.update(sql, data) > 0;
	}

	
	public List<GameUserDto> selectList(){
		String sql = "select * from game_user";
		return jdbcTemplate.query(sql, gameUserMapper);
	}
	
	private Map<String, String> columnExample = Map.of(
		"아이디", "game_user_id",
		"직업", "game_user_job",
		"레벨", "game_user_level"
	);
	
	public List<GameUserDto> selectList(String column, String keyword){
		String columnName = columnExample.get(column);
		if(columnName == null) throw new RuntimeException("항목 오류");
		String sql = "select * from game_user "
				+ "where instr(" + columnName + ", ?) > 0 "
				+ "order by " + columnName + " asc, game_user_no asc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, gameUserMapper, data);
	}
	
	public GameUserDto selectOne(int gameUserNo) {
		String sql = "select * from game_user where game_user_no = ?";
		Object[] data = {gameUserNo};
		List<GameUserDto> list = jdbcTemplate.query(sql, gameUserMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
}
