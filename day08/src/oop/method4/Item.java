package oop.method4;

public class Item {
	//멤버 필드
	String name;
	String type;
	int price;
	int rate;
	int qty;
	boolean early;
	
	//멤버 메서드
	//<--처음에 있을수록 중요한 변수						뒤로 갈 수록 옵션 변수-->
	void init(String name, String type, int price, int qty, int rate, boolean early) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.qty = qty;
		this.rate = rate;
		this.early = early;
	}
	void init(String name, String type, int price, int qty, int rate) {
		this.init(name, type, price, qty, rate, false);
	}
	void init(String name, String type, int price, int qty) {
		this.init(name, type, price, qty, rate, false);
	}
	void init(String name, String type, int price) {
		this.init(name, type, price, qty, rate, false);
	}
	
	void show() {
		System.out.println("[상품 정보]");
		System.out.println("상품명 : "+this.name);
		System.out.println("상품분류 : "+this.type);
		if(this.rate == 0 ) {
			System.out.println("판매가 : 원가");
		} else {
			System.out.println("판매가 : 할인가(원가)");
		}
		System.out.println("수량 : "+this.qty);
		System.out.println("새벽배송 가능하며 3천원 추가됩니다.");
	}
}
