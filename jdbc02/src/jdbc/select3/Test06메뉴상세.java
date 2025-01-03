package jdbc.select3;

import jdbc.dao.MenuDao;
import jdbc.dto.MenuDto;

public class Test06메뉴상세 {

	public static void main(String[] args) {
		int menuNo = 4;
		
		MenuDao menuDao = new MenuDao();
		MenuDto menuDto = menuDao.selectOne(menuNo);
		
		if(menuDto != null) {
			System.out.print("["+menuDto.getMenuNo()+"]");
			System.out.print(menuDto.getMenuName());
			System.out.print("("+menuDto.getMenuType()+")");
			System.out.print(" / 가격: "+menuDto.getMenuPrice()+"원 / ");
			if(menuDto.getMenuEvent()=="Y") System.out.println("행사중");
			else System.out.println("행사제외");
		} else System.out.println("존재하지 않는 메뉴 번호");
	}

}
