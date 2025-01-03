package jdbc.select3;

import jdbc.dao.ItemDao;
import jdbc.dto.ItemDto;

public class Test08아이템상세 {

	public static void main(String[] args) {
		int itemNo = 2;
		
		ItemDao itemDao = new ItemDao();
		ItemDto itemDto = itemDao.selectOne(itemNo);
		
		if(itemDto != null) {
			System.out.print("[" + itemDto.getItemNo() + "] ");
			System.out.print("상품명 : " + itemDto.getItemName());
			System.out.print("(" + itemDto.getItemType() + ") ");
			if(itemDto.getItemQty() == 0) {
				System.out.print("[재고 없음]");
			} else System.out.print("재고:" + itemDto.getItemQty() + "개, ");
			System.out.print("가격:" + itemDto.getItemPrice()+"원");
			if(itemDto.getItemEarly() == "Y") {
				System.out.println(" :: 새벽배송 가능");
			} else System.out.println(" :: 새벽배송 불가능");
		} else System.out.println("존재하지 않는 상품 번호");

	}

}
