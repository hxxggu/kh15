package com.kh.spring12.dao.websocket;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.websocket.MemberMessageDto;
import com.kh.spring12.dto.websocket.MemberMessageViewDto;

@Repository
public class MemberMessageDao {

	@Autowired
	private SqlSession sqlSession;

	public MemberMessageDto add(MemberMessageDto memberMessageDto) {
		long memberMessageNo = sqlSession.selectOne("memberMessage.sequence");
		memberMessageDto.setMemberMessageNo(memberMessageNo);
		sqlSession.insert("memberMessage.add", memberMessageDto);
		return memberMessageDto;
	}
	
	public List<MemberMessageViewDto> selectListForAnonymous() {
 		return sqlSession.selectList("memberMessage.listForAnonymous");
 	}
	
	public List<MemberMessageViewDto> selectListForMember(String userId) {
 		return sqlSession.selectList("memberMessage.listForMember", userId);
 	} 

}
