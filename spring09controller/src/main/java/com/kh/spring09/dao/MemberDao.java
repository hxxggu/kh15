package com.kh.spring09.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.mapper.MemberMapper;

@Repository //제어반전(IoC)
public class MemberDao {
	
	@Autowired //의존성 주입(DI)
	private MemberMapper memberMapper;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//가입(등록) 메서드
	// 사용자 입력항목 : 14개 중 9개를 입력하며 필수는 4개
	//	- 아이디, 비밀번호, 닉네임, 생년월일, 연락처, 이메일
	//	- 주소(우편번호, 기본주소, 상세주소)
	public void insert(MemberDto memberDto) {
		String sql = "insert into member(" //필수 항목만 기재
				+ "member_id, member_pw, member_nickname,"
				+ "member_birth, member_contact, member_email,"
				+ "member_post, member_address1, member_address2) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
//		String sql = "insert into member("	//전체 필드 기재
//				+ "member_id, member_pw, member_nickname, "
//				+ "member_birth, member_contact, member_email, member_level, "
//				+ "member_post, member_address1, member_address2, "
//				+ "member_join, member_login, member_change) "
//				+ "values(?, ?, ?, ?, ?, ?, '일반회원', 0, ?, ?, ?, systimestamp, null, null)";
		
		Object[] data = {
				memberDto.getMemberId(),
				memberDto.getMemberPw(),
				memberDto.getMemberNickname(),
				memberDto.getMemberBirth(),
				memberDto.getMemberContact(),
				memberDto.getMemberEmail(),
				memberDto.getMemberPost(),
				memberDto.getMemberAddress1(),
				memberDto.getMemberAddress2()
		};
	}
	
	//상세조회 기능
	public MemberDto selectOne(String memberId) {
		String sql = "select * from member where member_id = ?";
		Object[] data = {memberId};
		List<MemberDto> list = jdbcTemplate.query(sql, memberMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	
}