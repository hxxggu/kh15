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
	public void init(String name, String color, int price, int speed) {
		this.setName(name);
		this.setColor(color);
		this.setPrice(price);
		this.setSpeed(speed);
	}
	
	//출력
	public void show() {
		System.out.println("[ 차량 정보 ] ");
		System.out.println("이름 : " + this.getName());
		System.out.println("색상 : " + this.getColor());
		System.out.println("가격 : " + this.getPrice());
		System.out.println("최대 속도 : " + this.getSpeed());
	}
	
}
