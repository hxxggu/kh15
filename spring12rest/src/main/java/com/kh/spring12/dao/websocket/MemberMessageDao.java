package com.kh.spring12.dao.websocket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public List<MemberMessageViewDto> selectListForAnonymousByPaging() {
		return sqlSession.selectList("memberMessage.listForAnonymousByPaging");
	}
	
	public List<MemberMessageViewDto> selectListForAnonymousByPaging(long memberMessageNo) {
		return sqlSession.selectList("memberMessage.listForAnonymousByPaging", memberMessageNo);
	}
	
	public List<MemberMessageViewDto> selectListForMemberByPaging(String userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return sqlSession.selectList("memberMessage.listForMemberByPaging", params);
	}
	
	public List<MemberMessageViewDto> selectListForMemberByPaging(String userId, long memberMessageNo) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("memberMessageNo", memberMessageNo);
		return sqlSession.selectList("memberMessage.listForMemberByPaging", params);
	}
	
	// 비회원의 처음과 더보기
	public int countForAnonymousByPaging() {
		return sqlSession.selectOne("memberMessage.countForAnonymousByPaging");
	}
	public int countForAnonymousByPaging(long memberMessageNo) {
		Map<String, Object> params = new HashMap<>();
		params.put("memberMessageNo", memberMessageNo);
		return sqlSession.selectOne("memberMessage.countForAnonymousByPaging", params); 
	}
	
	// 회원의 처음과 더보기
	public int countForMemberByPaging(String userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return sqlSession.selectOne("membetMessage.countForMemberByPaging", params);
	}
	public int countForMemberByPaging(String userId, long memberMessageNo) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("memberMessageNo", memberMessageNo);
		return sqlSession.selectOne("membetMessage.countForMemberByPaging", params);
	}

}
