package jdbc.select2;

import java.util.List;

import jdbc.dao.MenuDao;
import jdbc.dto.MenuDto;

public class Test06메뉴검색 {

	public static void main(String[] args) {
		
		String column = "종류"; //이름, 종류
		String keyword = "디저트";
		
		MenuDao menuDao = new MenuDao();
		List<MenuDto> list = menuDao.selectList(column, keyword);
		
		for(MenuDto menuDto : list) {
			System.out.print("["+menuDto.getMenuNo()+"]");
			System.out.print(menuDto.getMenuName());
			System.out.print("("+menuDto.getMenuType()+")");
			System.out.print(" / 가격: "+menuDto.getMenuPrice()+"원 / ");
			if(menuDto.getMenuEvent()=="Y") System.out.println("행사중");
			else System.out.println("행사제외");
		}
	}
}
