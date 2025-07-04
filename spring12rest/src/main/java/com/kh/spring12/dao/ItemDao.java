package com.kh.spring12.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.AttachmentDto;
import com.kh.spring12.dto.ItemDto;

@Repository
public class ItemDao {
	@Autowired
	private SqlSession sqlSession;
	 
	public List<ItemDto> selectList() {
		return sqlSession.selectList("item.list");
	}
	public ItemDto selectOne(long itemNo) {
		return sqlSession.selectOne("item.find", itemNo);
	}
	public ItemDto selectOne(ItemDto itemDto) {
		return sqlSession.selectOne("item.find", itemDto);
	}
	public ItemDto insert(ItemDto itemDto) {
		long sequence = sqlSession.selectOne("item.sequence");
		itemDto.setItemNo(sequence);
		sqlSession.insert("item.add", itemDto);
		return sqlSession.selectOne("item.find", sequence);
	}
	// 이미지 연결
	public void connect(ItemDto itemDto, AttachmentDto attachmentDto) {
		Map<String, Object> params = new HashMap<>();
		params.put("itemNo", itemDto.getItemNo());
		params.put("attachmentNo", attachmentDto.getAttachmentNo());
		sqlSession.insert("item.connect", params);
	}
	//이미지 찾기
	public int findImage(long itemNo) {
		return sqlSession.selectOne("item.findImage", itemNo);
	}
}