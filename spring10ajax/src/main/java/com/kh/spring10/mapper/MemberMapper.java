package com.kh.spring10.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring10.dto.MemberDto;

@Component
public class MemberMapper implements RowMapper<MemberDto>{ //역할이 명확할 경우 상속, 역할만 있고 형태는 자유로워도 되는 경우는 상속X

	@Override
	public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDto memberDto = new MemberDto();
		//모든 항목을 복사
		memberDto.setMemberId(rs.getString("member_id"));
		memberDto.setMemberPw(rs.getString("member_pw"));
		memberDto.setMemberNickname(rs.getString("member_nickname"));
		memberDto.setMemberBirth(rs.getString("member_birth"));
		memberDto.setMemberContact(rs.getString("member_contact"));
		memberDto.setMemberEmail(rs.getString("member_email"));
		memberDto.setMemberLevel(rs.getString("member_level"));
		memberDto.setMemberPoint(rs.getInt("member_point"));
		memberDto.setMemberPost(rs.getString("member_post"));
		memberDto.setMemberAddress1(rs.getString("member_address1"));
		memberDto.setMemberAddress2(rs.getString("member_address2"));
		memberDto.setMemberJoin(rs.getTimestamp("member_join"));
		memberDto.setMemberLogin(rs.getTimestamp("member_login"));
		memberDto.setMemberChange(rs.getTimestamp("member_change"));

		return memberDto;
	} 
	
}
