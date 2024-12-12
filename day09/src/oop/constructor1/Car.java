package oop.constructor1;

public class Car {
	
	String name;
	String color;
	int price;
	int speed;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
//초기화 메서드
//	public void init(String name, String color, int price, int speed) {
//		this.setName(name);
//		this.setColor(color);
//		this.setPrice(price);
//		this.setSpeed(speed);
//	}
//	
	//출력
	public void show() {
		System.out.println("[ 차량 정보 ] ");
		System.out.println("이름 : " + this.getName());
		System.out.println("색상 : " + this.getColor());
		System.out.println("가격 : " + this.getPrice());
		System.out.println("최대 속도 : " + this.getSpeed());
	}
	
	//생성자(constructor)
	//: 인스턴스를 생성할 때 정보를 설정할 수 있는 용도의 구문
	//: 없어도 클래스는 인스턴스 생성을 위한 도구이므로 자동으로 한 개를 생성
	//public car(){}  //기본 생성자(default constructor)
	
	//: init 메서드와 하는 역할이 같지만 "생성하면서" 설정한다는 것이 다름
	//: 생성자를 만들면 해당하는 생성자로 생성 방법이 고정됨(강제됨)
	//: 생성자도 오버로딩이 가능
	//: 생성자는 반드시 클래스와 이름이 동일해야 함
	public Car(String name, String color, int price, int speed) {
		this.setName(name);
		this.setColor(color);
		this.setPrice(price);
		this.setSpeed(speed);
	}
	
	
	
	
	
	
	
}
