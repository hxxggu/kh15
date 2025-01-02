package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.PhoneDto;

public class PhoneMapper implements RowMapper<PhoneDto> {

	@Override
	public PhoneDto mapRow(ResultSet rs, int idx) throws SQLException {
		PhoneDto phoneDto = new PhoneDto();
		
		phoneDto.setPhoneNo(rs.getInt("phone_no"));
		phoneDto.setPhoneName(rs.getString("phone_name"));
		phoneDto.setPhoneTelecom(rs.getNString("phone_telecom"));
		phoneDto.setPhonePrice(rs.getInt("phone_price"));
		phoneDto.setPhoneContract(rs.getInt("phone_contract"));
		
		return phoneDto;
	}
	
}
