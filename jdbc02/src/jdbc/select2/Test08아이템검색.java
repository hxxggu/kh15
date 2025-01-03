package jdbc.select2;

import java.util.List;

import jdbc.dao.ItemDao;
import jdbc.dto.ItemDto;


public class Test08아이템검색 {
	public static void main(String[] args) {
		String column = "새벽배송여부"; //상품명, 상품종류, 새벽배송여부
		String keyword = "Y";
		
		ItemDao itemDao = new ItemDao();
		List<ItemDto> list = itemDao.selectList(column, keyword);
		
		for(ItemDto itemDto : list) {
			System.out.print("[" + itemDto.getItemNo() + "] ");
			System.out.print("상품명 : " + itemDto.getItemName());
			System.out.print("(" + itemDto.getItemType() + ") ");
			if(itemDto.getItemQty() == 0) {
				System.out.print("[재고 없음]"); break;
			} else System.out.print("재고:" + itemDto.getItemQty() + "개, ");
			System.out.print("가격:" + itemDto.getItemPrice()+"원");
			if(itemDto.getItemEarly() == "Y") {
				System.out.println(" :: 새벽배송 가능");
			} else System.out.println(" :: 새벽배송 불가능");
		}

	}
}
