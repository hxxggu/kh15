package com.kh.spring11.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring11.dto.CertDto;
import com.kh.spring11.mapper.CertMapper;

@Repository
public class CertDao {
	
	@Autowired
	private CertMapper certMapper;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// email 이 primary key 이기 때문에, 두 번 이상 발송 시 에러가 발생
	public void insert(CertDto certDto) {
		String sql = "insert into cert(cert_email, cert_number) values(?, ?)";
		Object[] data = {certDto.getCertEmail(), certDto.getCertNumber()};
		jdbcTemplate.update(sql, data);
	}
	
	public boolean update(CertDto certDto) {
		String sql = "update cert set cert_number = ? where cert_email = ?";
		Object[] data = {certDto.getCertNumber(), certDto.getCertEmail()};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	public CertDto selectOne(String certEmail) {
		String sql = "select * from cert where cert_email = ?";
		Object[] data = {certEmail};
		List<CertDto> list = jdbcTemplate.query(sql, certMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	// 두 번 이상 실행해도 에러가 나지 않음
	public void insertOrUpdate(CertDto certDto) {
		if(selectOne(certDto.getCertEmail()) == null) { // 인증 내역이 없는 이메일
			insert(certDto);
		} else { // 이미 인증 내역이 존재
			update(certDto);
		}
	}
	
}
