package oop.method3;

public class Cafe {
	String menu;
	String section;
	float price;
	String state;
	
	void init(String m, String sec, float p, String s) {
		this.menu = m;
		this.section = sec;
		this.price = p;
		this.state = s;
	}
	
	void show() { 
		if(state == "행사중") {
			System.out.println("메뉴명 : "+menu+" (행사중)");
			System.out.println("분류 : "+section);
			System.out.println("가격 : "+(price-(price*0.2f)+"원"));
		} else {
			System.out.println("메뉴명 : "+menu);
			System.out.println("분류 : "+section);
			System.out.println("가격 : "+price);
		}
		
		
	}
}
