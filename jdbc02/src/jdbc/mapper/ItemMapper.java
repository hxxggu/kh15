package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.ItemDto;

public class ItemMapper implements RowMapper<ItemDto>{

	@Override
	public ItemDto mapRow(ResultSet rs, int idx) throws SQLException {
		ItemDto itemDto = new ItemDto();
		
		itemDto.setItemNo(rs.getInt("item_no"));
		itemDto.setItemName(rs.getNString("item_name"));
		itemDto.setItemType(rs.getString("item_type"));
		itemDto.setItemPrice(rs.getInt("item_price"));
		itemDto.setItemDiscountRate(rs.getObject("item_discount_rate", Float.class));
		itemDto.setItemQty(rs.getInt("item_qty"));
		itemDto.setItemEarly(rs.getString("item_early"));
		
		return itemDto;
	}

}
