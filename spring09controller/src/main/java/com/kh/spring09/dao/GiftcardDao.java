package com.kh.spring09.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.GiftcardDto;
import com.kh.spring09.mapper.GiftcardMapper;

@Repository
public class GiftcardDao {

	@Autowired
	private GiftcardMapper giftcardMapper;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//시퀀스 생성 + 등록
	public int sequence() {
		String sql = "select giftcard_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insert(GiftcardDto giftcardDto) {
		String sql = "insert into giftcard("
							+ "giftcard_no, giftcard_name, giftcard_content,"
							+ "giftcard_charge, giftcard_price"
						+ ") values(?, ?, ?, ?, ?)";
		Object[] data = {
			giftcardDto.getGiftcardNo(), giftcardDto.getGiftcardName(),
			giftcardDto.getGiftcardContent(), giftcardDto.getGiftcardCharge(),
			giftcardDto.getGiftcardPrice()
		};
		jdbcTemplate.update(sql, data);
	}
	
	public void connect(int giftcardNo, int attachmentNo) {
		String sql = "insert into giftcard_image(giftcard_no, attachment_no) values(?, ?)";
		Object[] data = {giftcardNo, attachmentNo};
		jdbcTemplate.update(sql, data);
	}
	
}