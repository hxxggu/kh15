package jdbc.dao;

import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.CountryDto;
import jdbc.dto.PhoneDto;
import jdbc.mapper.PhoneMapper;
import jdbc.util.JdbcFactory;

public class PhoneDao {

	//등록 메소드
	public void insert(PhoneDto phoneDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "insert into phone(phone_no, phone_name, phone_telecom, phone_price, phone_contract) "
				+ "values(phone_seq.nextval, ?, ?, ?, ?)";
		Object[] data = {
				phoneDto.getPhoneName(), phoneDto.getPhoneTelecom(),
				phoneDto.getPhonePrice(), phoneDto.getPhoneContract()
		};
		jdbcTemplate.update(sql, data);
	}
	
	public boolean update(PhoneDto phoneDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "update phone "
				+ "set phone_name = ?, phone_telecom = ?, "
				+ "phone_price = ?, phone_contract = ? "
				+ "where phone_no = ?";
		Object[] data = {
				phoneDto.getPhoneName(),
				phoneDto.getPhoneTelecom(),
				phoneDto.getPhonePrice(),
				phoneDto.getPhoneContract(),
				phoneDto.getPhoneNo()
		};
		int rows = jdbcTemplate.update(sql, data);
		return rows > 0;
	}
	
	public boolean delete(int phoneNo) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "delete phone where phone_no = ?";
		Object[] data = {phoneNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	private PhoneMapper phoneMapper = new PhoneMapper();
	
	public List<PhoneDto> selectList(){
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from phone";
		return jdbcTemplate.query(sql, phoneMapper);
		
	}
	
	private Map<String, String> columnExample = Map.of(
		"기종", "phone_name",
		"할부기간", "phone_conract",
		"통신사", "phone_telecom"
	);
	
	public List<PhoneDto> selectList(String column, String keyword) {
		String columnName = columnExample.get(column);
		if(columnName == null) throw new RuntimeException();
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from phone "
				+ "where instr(" + columnName + ", ?) > 0 "
				+ "order by " + columnName + " asc, phone_no asc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, phoneMapper, data);
	}
	
	public PhoneDto selectOne(int phoneNo) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from phone where phone_no = ?";
		Object[] data = {phoneNo};
		List<PhoneDto> list = jdbcTemplate.query(sql, phoneMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
}