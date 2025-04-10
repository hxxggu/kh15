package com.kh.spring12.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.AttachmentDto;

@Repository
public class AttachmentDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public AttachmentDto insert(AttachmentDto attachmentDto) {
		int attachmentNo = sqlSession.selectOne("attachment.sequence");
		attachmentDto.setAttachmentNo(attachmentNo);
		sqlSession.insert("attachment.add", attachmentDto);
		return attachmentDto; // DB를 한번이라도 덜 갈 수 있음
//		return sqlSession.selectOne("attachment.find", attachmentNo);
	}

}
