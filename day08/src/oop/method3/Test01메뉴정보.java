package oop.method3;

public class Test01메뉴정보 {

	public static void main(String[] args) {
		//인스턴스(객체) 생성
		Menu a = new Menu();
		Menu b = new Menu();
		Menu c = new Menu();
		Menu d = new Menu();
		
		//초기화
		a.init("아메리카노", "음료", 2500, true);
		b.init("모카라떼", "음료", 3500);
		c.init("치즈케이크", "디저트", 5000, true);
		d.init("마카롱", "디저트", 3000);
		
		//출력
		a.show();
		b.show();
		c.show();
		d.show();
	}
}
