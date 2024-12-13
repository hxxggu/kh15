package oop.inherit6;

public class Test01추상클래스 {

	public static void main(String[] args) {
		//추상클래스는 인스턴스 생성이 불가능하다
		//Phone p = new Phone();
		
		Galaxy p = new Galaxy();
		p.call();
		p.sms();
		p.internet();
	}

}
