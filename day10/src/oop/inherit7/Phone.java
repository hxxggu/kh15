package oop.inherit7;

public abstract class Phone { //abstract : 상위클래스임을 명시
	//필드
	protected String num;
	protected String color;

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	//생성자
	public Phone(String num, String color) {
		this.setNum(num);
		this.setColor(color);
	}
	
	//메서드
	public abstract void call();
	public abstract void sms();
	public final void show(String num, String color) {
		System.out.println("[ 전화기 정보 ]");
		System.out.println("전화 번호 : "+this.num);
		System.out.println("색상 : "+this.color);
	}
}