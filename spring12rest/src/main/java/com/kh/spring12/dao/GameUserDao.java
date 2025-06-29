package com.kh.spring12.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.GameUserDto;
import com.kh.spring12.mapper.GameUserMapper;

@Repository
public class GameUserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private GameUserMapper gameUserMapper;

	//등록 메소드
	public void insert(GameUserDto gameUserDto) {
		String sql = "insert into game_user(game_user_no, game_user_id, game_user_job, game_user_level, game_user_money) "
				+ "values(game_user_seq.nextval, ?, ?, ?, ?)";
		Object[] data = {
			gameUserDto.getGameUserId(),
			gameUserDto.getGameUserJob(),
			gameUserDto.getGameUserLevel(),
			gameUserDto.getGameUserMoney()
		};
		jdbcTemplate.update(sql, data);
	}
	
	//시퀀스+등록 메서드
	public int sequence() {
		String sql = "select game_user_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insert2(GameUserDto gameUserDto) {
		String sql = "insert into game_user(game_user_no, "
				+ "game_user_id, game_user_job, game_user_level, "
				+ "game_user_money) "
				+ "values(?, ?, ?, ?, ?)";
		Object[] data = {
			gameUserDto.getGameUserNo(),
			gameUserDto.getGameUserId(),
			gameUserDto.getGameUserJob(),
			gameUserDto.getGameUserLevel(),
			gameUserDto.getGameUserMoney()
		};
		jdbcTemplate.update(sql, data);
	}
	
	//수정 메소드
	public boolean update(GameUserDto gameUserDto) {
		String sql = "update game_user set "
							+ "game_user_id=?, game_user_job=?, "
							+ "game_user_level=?, game_user_money=? "
						+ "where game_user_no=?";
		Object[] data = {
			gameUserDto.getGameUserId(),
			gameUserDto.getGameUserJob(),
			gameUserDto.getGameUserLevel(),
			gameUserDto.getGameUserMoney(),
			gameUserDto.getGameUserNo()
		};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//삭제 메소드
	public boolean delete(int gameUserNo) { 
		String sql = "delete game_user where game_user_no=?";
		Object[] data = {gameUserNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//조회 메소드
	public List<GameUserDto> selectList() {
		String sql = "select * from game_user";
		return jdbcTemplate.query(sql, gameUserMapper);
	}
	
	
	private Map<String, String> columnExamples = Map.of(
		"아이디", "game_user_id",
		"직업", "game_user_job"
	);
	
	public List<GameUserDto> selectList(String column, String keyword) {
		String columnName = columnExamples.get(column);
		if(columnName == null) throw new RuntimeException("항목 오류");
		
		String sql = "select * from game_user where instr(#1, ?) > 0 "
						+ "order by #1 asc, game_user_no asc";
		sql = sql.replace("#1", columnName);
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, gameUserMapper, data);
	}
	
	//상세조회 메소드
	public GameUserDto selectOne(int gameUserNo) {
		String sql = "select * from game_user where game_user_no = ?";
		Object[] data = {gameUserNo};
		List<GameUserDto> list = jdbcTemplate.query(sql, gameUserMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	//레벨업 메서드
	public boolean increaseGameUserLevel(int gameUserNo) {
		String sql = "update game_user "
				+ "set game_user_level = game_user_level+1 "
				+ "where game_user_no = ?";
		Object[] data = {gameUserNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//유저 프로필 등록(연결)
		public void connect(int gameUserNo, int attachmentNo) {
			String sql = "insert into game_user_profile(game_user_no, attachment_no) values(?, ?)";
			Object[] data = {gameUserNo, attachmentNo};
			jdbcTemplate.update(sql, data);
		}
		public int findAttachment(int gameUserNo) {
			String sql = "select attachment_no from game_user_profile where game_user_no=?";
			Object[] data = {gameUserNo};
			return jdbcTemplate.queryForObject(sql, int.class, data);
		}
}