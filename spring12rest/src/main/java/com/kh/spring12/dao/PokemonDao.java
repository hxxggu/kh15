package com.kh.spring12.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.PokemonDto;
import com.kh.spring12.vo.SearchVO;

// DAO는 영속성 항목을 제어하는 도구
// - 영속성이라는건 파일이나 데이터베이스처럼 놔두면 영원히 유지되는것을 의미
// - 영속성 항목을 제어하는 도구들은 @Repository로 등록
@Repository
public class PokemonDao {
	
	// 여기서 필요로 하는 도구들을 등록된 도구중에서 가지고 온다(DI)
	@Autowired
	private SqlSession sqlSession;
	
	// 목록
	public List<PokemonDto> selectList() { 
		// sqlSession을 이용해서
		// namespace = "pokemon" 영역을 찾아
		// id = "list" 인 구문을 실행하시오
		return sqlSession.selectList("pokemon.list");
	}
	
	//검색
	public List<PokemonDto> selectList(String column, String keyword) {
		Map<String, Object> param = new HashMap<>();
		param.put("column", column);
		param.put("keyword", keyword);
		return sqlSession.selectList("pokemon.listOrSearch", param);
	}
	
	public List<PokemonDto> selectList(SearchVO searchVO) {
		return sqlSession.selectList("pokemon.listOrSearch", searchVO);
	}

	// 등록 (1) - 시퀀스 자동 생성
	public void insert(PokemonDto pokemonDto) {
		sqlSession.insert("pokemon.add", pokemonDto);
	}
	
	// 시퀀스+등록
	public int sequence() {
		return sqlSession.selectOne("pokemon.sequence");
	}
	public void insert2(PokemonDto pokemonDto) {
		sqlSession.insert("pokemon.add2", pokemonDto);
	}
	
	// 삭제 메서드
	public boolean delete(int pokemonNo) {
		return sqlSession.delete("pokemon.delete", pokemonNo) > 0;
	}
	
	// 수정 메소드
	public boolean update(PokemonDto pokemonDto) {
		return sqlSession.update("pokemon.edit", pokemonDto) > 0;
	}
	
	// 상세조회 메소드
	public PokemonDto selectOne(int pokemonNo) {
		// 단일조회는 부를 때, selectOne으로 부른다
		return sqlSession.selectOne("pokemon.find", pokemonNo);
	}
	
//	// 포켓몬 이미지 등록(연결)
//		public void connect(int pokemonNo, int attachmentNo) {
//			String sql = "insert into pokemon_image ("
//								+ "pokemon_no, attachment_no"
//						+ ") values(?, ?)";
//			Object[] data = { pokemonNo, attachmentNo };
//			jdbcTemplate.update(sql, data);
//		}
//		
//		// 포켓몬 이미지 찾기
//		// - 반환형이 int이기 때문에 만약 이미지가 없으면 예외가 발생함
//		public int findAttachment(int pokemonNo) {
//			String sql = "select attachment_no from pokemon_image "
//							+ "where pokemon_no=?";
//			Object[] data = {pokemonNo};
//			return jdbcTemplate.queryForObject(sql, int.class, data);
//		}
//		
//
////		게시글 좋아요 관련 처리 기능
//		
//		// 좋아요 설정
//		public void insertPokemonLike(String memberId, int pokemonNo) {
//			String sql = "insert into pokemon_like(member_id, pokemon_no) values(?, ?)";
//			Object[] data = { memberId, pokemonNo };
//			jdbcTemplate.update(sql, data);
//		}
//		
//		// 좋아요 해제
//		public void deletePokemonLike(String memberId, int pokemonNo) {
//			String sql = "delete pokemon_like where member_id=? and pokemon_no=?";
//			Object[] data = { memberId, pokemonNo };
//			jdbcTemplate.update(sql, data);
//		}
//		
//		// 좋아요 검사
//		public boolean checkPokemonLike(String memberId, int pokemonNo) {
//			String sql = "select count(*) from pokemon_like where member_id=? and pokemon_no=?";
//			Object[] data = { memberId, pokemonNo };
//			return jdbcTemplate.queryForObject(sql, int.class, data) > 0;
//		}
//		
//		// 좋아요 개수
//		public int countPokemonLike(int pokemonNo) {
//			String sql = "select count(*) from pokemon_like where pokemon_no=?";
//			Object[] data = { pokemonNo };
//			return jdbcTemplate.queryForObject(sql, int.class, data);
//		}
//		
//		// 좋아요 개수를 갱신하는 메소드
//			public boolean updatePokemonLike(int pokemonNo, int count) {
//				String sql = "update pokemon set pokemon_like = ? where pokemon_no = ?";
//				Object[] data = {count, pokemonNo};
//				return jdbcTemplate.update(sql, data) > 0;
//			}
//			public boolean updatePokemonLike(int pokemonNo) {
//				String sql = "update pokemon set pokemon_like = ("
//									+ "select count(*) from pokemon_like where pokemon_no = ?"
//								+ ") where pokemon_no = ?";
//				Object[] data = {pokemonNo, pokemonNo}; //홀더 개수와 순서에 맞게
//				return jdbcTemplate.update(sql, data) > 0;
//			}
//		
}