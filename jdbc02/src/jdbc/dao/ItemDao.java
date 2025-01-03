package jdbc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.ItemDto;
import jdbc.dto.PhoneDto;
import jdbc.mapper.ItemMapper;
import jdbc.util.JdbcFactory;

public class ItemDao {
	public void insert(ItemDto itemDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "insert into item("
				+ "item_no, item_name, item_type, item_price,"
				+ "item_discount_rate, item_qty, item_early)"
				+ "values(item_seq.nextval, ?, ?, ?, ?, ?, ?)";
		Object[] data = {
				itemDto.getItemName(),
				itemDto.getItemType(),
				itemDto.getItemPrice(),
				itemDto.getItemDiscountRate(),
				itemDto.getItemQty(),
				itemDto.getItemEarly()
		};
		jdbcTemplate.update(sql, data);
	}
	
	public boolean update(ItemDto itemDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql =  "update item "
				+ "set item_name = ?, item_type = ?, item_price = ?, "
				+ "item_discount_rate = ?, item_qty = ?, item_early = ? "
				+ "where item_no = ?";
		Object[] data = {
				itemDto.getItemName(),
				itemDto.getItemType(),
				itemDto.getItemPrice(),
				itemDto.getItemDiscountRate(),
				itemDto.getItemQty(),
				itemDto.getItemEarly(),
				itemDto.getItemNo()
		};
	int rows = jdbcTemplate.update(sql, data);
	return rows > 0;
	}

	public boolean delete(int itemNo) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "delete item where item_no = ?";
		Object[] data = {itemNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	private ItemMapper itemMapper = new ItemMapper();
	
	public List<ItemDto> selectList() {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from item";
		return jdbcTemplate.query(sql, itemMapper);
	}
	
	private Map<String, String> columnExample = Map.of(
		"상품명", "item_name",
		"상품종류", "item_type",
		"새벽배송여부", "item_early"
		);
		
		public List<ItemDto> selectList(String column, String keyword) {
			String columnName = columnExample.get(column);
			if(columnName == null) throw new RuntimeException();
			JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
			String sql = "select * from item "
					+ "where instr(" + columnName + ", ?) > 0 "
					+ "order by " + columnName + " asc, item_no asc";
			Object[] data = {keyword};
			return jdbcTemplate.query(sql, itemMapper, data);
		}
	
}
