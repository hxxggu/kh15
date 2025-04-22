package com.kh.spring12.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.RoomDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class RoomDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 등록
	public RoomDto insert(RoomDto roomDto) {
		long roomNo = sqlSession.selectOne("room.sequence");
		roomDto.setRoomNo(roomNo);
		sqlSession.insert("room.create", roomDto);
		return roomDto;
	}
	
	// 조회
	public List<RoomDto> selectList() {
		return sqlSession.selectList("room.list");
	}
	
	// 상세
	public RoomDto selectOne(long roomNo) {
		return sqlSession.selectOne("room.find", roomNo);
	}
	
	// 삭제
	public boolean delete(long roomNo) {
		return sqlSession.delete("room.delete", roomNo) > 0;
	}
	
	public void enterRoom(long roomNo, String userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("roomNo", roomNo);
		params.put("userId", userId);
		sqlSession.insert("room.enter", params);
	}
	
	public boolean checkRoom(long roomNo, String userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("roomNo", roomNo);
		params.put("userId", userId);
		
		int count = sqlSession.selectOne("room.check", params);
		return count > 0;
		// select count(*) from room_user where room_no = ? and account_id = ?
	}
}
