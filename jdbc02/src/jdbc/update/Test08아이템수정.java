package jdbc.update;

import jdbc.dao.ItemDao;
import jdbc.dto.ItemDto;

public class Test08아이템수정 {
	public static void main(String[] args) {
		
		ItemDto itemDto = new ItemDto();
		itemDto.setItemNo(4);
		itemDto.setItemName("행주");
		itemDto.setItemType("잡화");
		itemDto.setItemPrice(3000);
		itemDto.setItemDiscountRate(10/100f);
		itemDto.setItemQty(20);
		itemDto.setItemEarly("Y");
		
		ItemDao itemDao = new ItemDao();
		boolean success = itemDao.update(itemDto);
		
		if(success) System.out.println("수정완료");
		else System.out.println("대상이 없습니다");
	}
}
