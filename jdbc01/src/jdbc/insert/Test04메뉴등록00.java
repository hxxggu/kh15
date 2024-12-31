package jdbc.insert;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcFactory;

public class Test04메뉴등록00 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String menuName = "메론소다";
		String menuType = "음료";
		int menuPrice = 6500;
		int menuEvent =1; 
				
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		
		String sql = "insert into menu("
				+ "menu_no, menu_name, menu_type, menu_price, menu_event)"
				+ "values(menu_seq.nextval, ?, ?, ?, ?)";
		
		Object[] data = {
				menuName, menuType, menuPrice,
				menuEvent == 1 ? "Y":"N"
				};
		
		jdbcTemplate.update(sql, data);
		System.out.println("메뉴 등록이 완료 되었습니다");
		
	}
}
