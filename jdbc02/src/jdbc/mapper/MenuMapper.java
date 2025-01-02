package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.MenuDto;

public class MenuMapper implements RowMapper<MenuDto>{

	@Override
	public MenuDto mapRow(ResultSet rs, int idx) throws SQLException {
		MenuDto menuDto = new MenuDto();
		
		menuDto.setMenuNo(rs.getInt("menu_no"));
		menuDto.setMenuName(rs.getNString("menu_name"));
		menuDto.setMenuType(rs.getNString("menu_type"));
		menuDto.setMenuPrice(rs.getInt("menu_price"));
		menuDto.setMenuEvent(rs.getString("menu_event"));
		
		return menuDto;
	}
}
