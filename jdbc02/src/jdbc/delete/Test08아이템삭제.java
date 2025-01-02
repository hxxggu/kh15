package jdbc.delete;

import jdbc.dao.ItemDao;

public class Test08아이템삭제 {
	public static void main(String[] args) {
		
		int itemNo = 5;
		
		ItemDao itemDao = new ItemDao();
		boolean success = itemDao.delete(itemNo);
		
		if(success) System.out.println("삭제 완료");
		else System.out.println("존재하지 않는 상품 번호");
	}
}
