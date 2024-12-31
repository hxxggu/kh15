package jdbc.insert;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcFactory;

public class Test05아이템등록 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String itemName = "블록";
		String itemType = "장난감";
		int itemPrice = 20000;
		Integer itemDiscountRate = 1;
		int itemQty = 3;
		System.out.print("새벽 배송 여부(1:가능 2:불가능) : ");
		int inputEarly = sc.nextInt();
		String itemEarly = null;
		if(inputEarly==1) itemEarly="Y";
		else if(inputEarly==2) itemEarly="N";
		
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		
		String sql = "insert into item"
				+ "(item_no, item_name, item_type, item_price, item_discount_rate, item_qty, item_early) "
				+ "values(item_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		Object[] data = {itemName, itemType, itemPrice, itemDiscountRate, itemQty, itemEarly};
		
		jdbcTemplate.update(sql, data);
		System.out.println("아이템 입력이 완료 되었습니다");
	}

}
