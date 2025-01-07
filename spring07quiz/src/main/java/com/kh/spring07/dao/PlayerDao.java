package com.kh.spring07.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring07.dto.PlayerDto;
import com.kh.spring07.mapper.PlayerMapper;

@Repository
public class PlayerDao {
	@Autowired
	private PlayerMapper playerMapper;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(PlayerDto playerDto) {
		String sql = "insert into player(player_no, player_name, "
				+ "player_event, player_type, player_gold_medal, "
				+ "player_silver_medal, player_bronze_medal "
				+ "values(player_seq.nextval, ?, ?, ?, ?, ?, ?)";
		Object[] data = {
				playerDto.getPlayerName(),
				playerDto.getPlayerEvent(),
				playerDto.getPlayerType(),
				playerDto.getPlayerGoldMedal(),
				playerDto.getPlayerSilverMedal(),
				playerDto.getPlayerBronzeMedal()
		};
		jdbcTemplate.update(sql, data);		
	}
	
	public boolean update(PlayerDto playerDto) {
		String sql = "update player "
				+ "set player_name = ?, player_event = ?, player_type = ?, "
				+ "player_gold_medal = ?, player_silver medal = ?, "
				+ "player_bronze_medal = ? where player_no = ?";
		Object[] data = {
				playerDto.getPlayerName(),
				playerDto.getPlayerEvent(),
				playerDto.getPlayerType(),
				playerDto.getPlayerGoldMedal(),
				playerDto.getPlayerSilverMedal(),
				playerDto.getPlayerBronzeMedal(),
				playerDto.getPlayerNo()
		};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	public boolean delete(int playerNo) {
		String sql = "delete player where player_no = ?";
		Object[] data = {playerNo};
		return jdbcTemplate.update(sql, data) > 0;
	}

	public List<PlayerDto> selectList() {
		String sql = "select * from player";
		return jdbcTemplate.query(sql, playerMapper);
	}
	
	private Map<String, String> columnExample = Map.of(
		"이름", "player_name",
		"종목", "player_event",
		"시즌", "player_type"
	);
	
	public List<PlayerDto> selectList(String column, String keyword){
		String columnName = columnExample.get(column);
		if(columnName == null) throw new RuntimeException();
		String sql = "select * from player "
				+ "where instr(" + columnName +", ?) > 0 "
				+ "order by " + columnName + " asc, player_no asc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, playerMapper, data);
	}
	
	public PlayerDto selectOne(int playerNo) {
		String sql = "select * from player where player_no = ?";
		Object[] data = {playerNo};
		List<PlayerDto> list = jdbcTemplate.query(sql, playerMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
}
