package com.kh.spring09.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.AttachmentDto;
import com.kh.spring09.mapper.AttachmentMapper;

@Repository
public class AttachmentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private AttachmentMapper attachmentMapper;
	
	//등록(시퀀스 생성은 분리)
	public int sequence() {
		String sql = "select attachment_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insert(AttachmentDto attachmentDto) {
		String sql = "insert into attachment("
							+ "attachment_no, attachment_name, "
							+ "attachment_type, attachment_size"
					+ ") values(?, ?, ?, ?)";
		Object[] data = {
			attachmentDto.getAttachmentNo(), attachmentDto.getAttachmentName(),
			attachmentDto.getAttachmentType(), attachmentDto.getAttachmentSize()
		};
		jdbcTemplate.update(sql, data);
	}
	
	public boolean delete(int attachmentNo) {
		String sql = "delete attachment where attachment_no=?";
		Object[] data = {attachmentNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	public AttachmentDto selectOne(int attachmentNo) {
		String sql = "select * from attachment where attachment_no=?";
		Object[] data = {attachmentNo};
		List<AttachmentDto> list = jdbcTemplate.query(sql, attachmentMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
}




