package oop.multi2;

public class Airplane extends Transportation implements Flyable, Reserve {

	public void move() {
		System.out.println("비행기가 이동합니다");
	}
	
	@Override
	public void fly() {
		System.out.println("비헹기가 날아갑니다");
	}

	@Override
	public void reservation() {
		System.out.println("비행기를 예약합니다");
		
	}

}
