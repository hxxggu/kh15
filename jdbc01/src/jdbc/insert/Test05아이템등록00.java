package jdbc.insert;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.HsqlMaxValueIncrementer;

import jdbc.util.JdbcFactory;

public class Test05아이템등록00 {

	public static void main(String[] args) {
		
		//입력
		String itemName = "말랑카우";
		String itemType = "식품";
		int itemPrice = 2500;
		Float itemDiscountRate = null;
		int itemQty = 1;
		String itemEarly = "N";
		
		
		//처리(JDBC)
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "insert into item(item_no, item_name, item_type,"
				+ "item_price, item_discount_rate,)"
				+ "values(item_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		Object[] data = {
				itemName, itemType, itemPrice, itemDiscountRate,
				itemQty, itemEarly};
		jdbcTemplate.update(sql, data);
		
		
		//출력
		System.out.println("등록이 완료되었습니다");

	}

}
