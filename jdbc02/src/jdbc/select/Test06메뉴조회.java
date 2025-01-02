package jdbc.select;

import java.util.List;

import jdbc.dao.MenuDao;
import jdbc.dto.MenuDto;

public class Test06메뉴조회 {

	public static void main(String[] args) {
		MenuDao menuDao = new MenuDao();
		List<MenuDto> list = menuDao.selectList();
		
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