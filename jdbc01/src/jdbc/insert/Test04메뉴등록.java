package jdbc.insert;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcFactory;

public class Test04메뉴등록 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String menuName = "메론소다";
		String menuType = "음료";
		int menuPrice = 6500;
		System.out.print("행사 여부(1:행사중, 2:행사아님) : ");
		int inputEvent = sc.nextInt();
		String menuEvent =null;
		if(inputEvent == 1) menuEvent = "Y";
		else if(inputEvent == 2) menuEvent = "N";
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		
		String sql = "insert into menu("
				+ "menu_no, menu_name, menu_type, menu_price, menu_event)"
				+ "values(menu_seq.nextval, ?, ?, ?, ?)";
		
		Object[] data = {menuName, menuType, menuPrice, menuEvent};
		
		jdbcTemplate.update(sql, data);
		System.out.println("메뉴 입력이 완료 되었습니다");
		
	}
}
