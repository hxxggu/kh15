package jdbc.update;

import jdbc.dao.MenuDao;
import jdbc.dto.MenuDto;

public class Test06메뉴정보수정 {
	public static void main(String[] args) {
			MenuDto menuDto = new MenuDto();
			menuDto.setMenuNo(30);
			menuDto.setMenuName("사과파이");
			menuDto.setMenuType("디저트");
			menuDto.setMenuPrice(5000);
			menuDto.setMenuEvent("Y");
			
			MenuDao menuDao = new MenuDao();
			boolean success = menuDao.update(menuDto);
			
			if(success) System.out.println("수정완료");
			else System.out.println("대상이 없습니다");
	}
}
