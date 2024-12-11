package oop.method3;

public class Menu {
	//멤버 필드
	String name;
	String type;
	int price;
	boolean event;
	
	//멤버 메서드
	//- 메서드 오버로딩(method overloading)
	//	: 같은 이름으로 형태만 다르게 해서 여러 개의 메소드를 만드는 행위
	//	: 이용의 편리성을 극대화
	//	: 뭘 좋아할 지 몰라서 다 준비해봤어
	void init(String name, String type, int price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}
	
	void init(String name, String type, int price, boolean event) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.event = event;
	}
	
	void show() {
		System.out.println("[ 메뉴 정보 ]");
		if(this.event) {
			System.out.println("이름 : "+this.name+"(행사중)");
			System.out.println("구분 : "+this.type);
			System.out.println("가격 : "+this.price*80/100+"원");
		} else {
			System.out.println("이름 : "+this.name);
			System.out.println("구분 : "+this.type);
			System.out.println("가격 : "+this.price+"원");
		}
	}
}
