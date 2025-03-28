package com.kh.spring12.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.BookDto;
import com.kh.spring12.mapper.BookMapper;

@Repository
public class BookDao {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	@Autowired
	private BookMapper bookMapper;
	
		// 등록 메서드
	public void insert(BookDto bookDto) {
		String sql = "insert into book(book_id, book_title, book_author, book_publication_date, "
				+ "book_price, book_publisher, book_page_count, book_genre) "
				+ "values(book_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = {bookDto.getBookTitle(), bookDto.getBookAuthor(), bookDto.getBookPublicationDate(),
				bookDto.getBookPrice(), bookDto.getBookPublisher(), bookDto.getBookPageCount(), bookDto.getBookGenre()};
		jdbctemplate.update(sql, data);
	}
	
	// 시퀀스 생성, 등록 메서드
	public int sequence() {
		String sql = "select book_seq.nextval from dual";
		return jdbctemplate.queryForObject(sql, int.class);
	}
	public void insert2(BookDto bookDto) {
		String sql = "insert into book(book_id, book_title, book_author, book_publication_date, "
				+ "book_price, book_publisher, book_page_count, book_genre) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = {
				bookDto.getBookId(),
				bookDto.getBookTitle(),
				bookDto.getBookAuthor(),
				bookDto.getBookPublicationDate(),
				bookDto.getBookPrice(),
				bookDto.getBookPublisher(),
				bookDto.getBookPageCount(),
				bookDto.getBookGenre()
		};
		jdbctemplate.update(sql, data);
	}
	
	// 수정 메서드
	public boolean update(BookDto bookDto) {
		String sql = "update book "+"set book_title = ?, book_author = ?, book_publication_data = ?,"
				+ "book_price = ?, book_publisher = ?, book_page_count = ?, book_genre = ? "
				+ "where book_id = ?";
		Object[] data = {
				bookDto.getBookTitle(),
				bookDto.getBookAuthor(),
				bookDto.getBookPublicationDate(),
				bookDto.getBookPrice(),
				bookDto.getBookPublisher(),
				bookDto.getBookPageCount(),
				bookDto.getBookGenre()
		};
		int rows = jdbctemplate.update(sql, data);
		return rows > 0;
	}
	
	// 삭제 메서드
	public boolean delete(int bookId) {
		String sql = "delete book where book_id = ?";
		Object[] data = {bookId};
		return jdbctemplate.update(sql, data) > 0;
	}
	
	// 조회 메서드
	public List<BookDto> selectList() {
		String sql = "select * from book order by book_id asc";
		return jdbctemplate.query(sql, bookMapper);
	}
	
	// 검색 항목 설정
	private Map<String, String> columnExamples = Map.of("도서명", "book_title", 
			"작가", "book_author", "장르", "book_genre");
	
	// 검색 메서드
	public List<BookDto> selectList(String column, String keyword) {
		// 컬럼 변환
		String columnName = columnExamples.get(column);
		if(columnName == null) throw new RuntimeException("항목 오류");
		
		String sql = "select * from country " + "where instr(#1, ?) > 0 " + "order by #1 asc, country_no asc";
		sql = sql.replace("#1", columnName);
		Object[] data = {keyword};
		return jdbctemplate.query(sql, bookMapper, data);
		}
	
	// 상세 조회 메서드
	public BookDto selectOne(int bookId) {
		String sql = "select * from book where book_id = ?";
		Object[] data = {bookId};
		List<BookDto> list = jdbctemplate.query(sql, bookMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}

}
