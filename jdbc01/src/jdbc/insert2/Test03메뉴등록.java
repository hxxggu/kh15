package jdbc.insert2;

public class Test03메뉴등록 {

	public static void main(String[] args) {
		
		MenuDto menuDto = new MenuDto();
		
		menuDto.setMenuName("딸기생크림케이크");
		menuDto.setMenuType("디저트");
		menuDto.setMenuPrice(8500);
		menuDto.setMenuEvent("N");
		
		MenuDao menuDao = new MenuDao();
		menuDao.insert(menuDto);
		
		System.out.println("등록 완료");

	}

}
