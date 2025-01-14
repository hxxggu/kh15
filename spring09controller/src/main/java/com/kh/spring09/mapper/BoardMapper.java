package com.kh.spring09.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring09.dto.BoardDto;

@Component
public class BoardMapper implements RowMapper<BoardMapper> {

	@Override
	public BoardMapper mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardNo(rs.getInt("board_no"));
		boardDto.setBoardNo(rs.getString("board_title"));
		boardDto.setBoardNo(rs.getString("board_content"));
		boardDto.setBoard(rs.getString("board_writer"));
		boardDto.setBoardWtime(rs.getTimestamp("board_wtime"));
		boardDto.setBoardEtime(rs.getTimestamp("board_etime"));
		boardDto.setBoardNo(rs.getInt("board_"));
		return boardDto;
	}
	
	

} 
