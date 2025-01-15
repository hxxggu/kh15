package com.kh.spring09.dao;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.mapper.BoardMapper;

@Repository
public class BoardDao {
	
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//게시글 등록 메서드
	public void write(BoardDto boardDto) {
		String sql = "insert into board(board_no, board_title, "
				+ "board_content, board_Wtime) "
				+ "values(board_seq.nextval, ?, ?, ?, systimestamp)";
		Object[] data = {
				boardDto.getBoardTitle(),
				boardDto.getBoardContent(),
				boardDto.getBoardWtime(),
				boardDto.getBoardWriter()
		};
		jdbcTemplate.update(sql, data);
	}
	
	//검색 항목 설정
	private Map<String, String> columnExamples = Map.of(
			"제목", "board_title",
			"작성자", "board_writer"
			);
	
	//게시글 목록 및 검색 메서드
	public List<BoardDto> selectList(){
		String sql = "select * from board";
		return jdbcTemplate.query(sql, boardMapper);
	}
	
	public List<BoardDto> selectList(String column, String keyword) {
		String columnName = columnExamples.get(column);
		if(columnName == null) throw new RuntimeException("검색 오류");
		String sql = "select * from board where instr(#1, ?) > 0 "
				+ "order by #1 asc, board_no asc";
		sql = sql.replace("#1", columnName);
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, boardMapper, data);
	}
	
	public BoardDto selectOne(int boardNo) {
		String sql = "select * from board where board_no = ? "
				+ "order by board_Wtime asc";
		Object[] data= {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	//게시글 수정 메서드 (글 제목과 내용 수정, 수정 시각)
	public boolean update(BoardDto boardDto) {
		String sql = "update board set board_title = ?, "
				+ "board_content = ?, board_Etime = systimestamp "
				+ "where board_no = ?";
		
		Object[] data = {
				boardDto.getBoardTitle(),
				boardDto.getBoardContent(),
				boardDto.getBoardEtime(),
				boardDto.getBoardNo()
		};
		int rows = jdbcTemplate.update(sql, data);
		return rows > 0;
	}
	
	//게시글 삭제 메서드
	public boolean delete(int boardNo) {
		String sql = "delete board where board_no = ?";
		Object[] data = {boardNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
}
