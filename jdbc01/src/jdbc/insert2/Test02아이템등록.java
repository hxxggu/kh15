package jdbc.insert2;

public class Test02아이템등록 {
	public static void main(String[]args) {
		
		ItemDto itemDto = new ItemDto();
		itemDto.setItemName("당근");
		itemDto.setItemType("식품");
		itemDto.setItemPrice(1500);
		itemDto.setItemDiscountRate(0);
		itemDto.setItemQty(3);
		itemDto.setItemEarly("Y");
		
		ItemDao itemDao = new ItemDao();
		itemDao.insert(itemDto);
		
		System.out.println("등록 완료");
	}
}
