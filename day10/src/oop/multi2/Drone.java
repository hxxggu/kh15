package oop.multi2;

public class Drone extends Transportation implements Flyable, Electronic {
	
	public void move() {
		System.out.println("드론이 이동합니다");
	}

	@Override
	public void fly() {
		System.out.println("드론이 날아갑니다");
	}

	@Override
	public void on() {
		System.out.println("드론의 전원을 켭니다");		
	}

	@Override
	public void off() {
		System.out.println("드론의 전원을 끕니다");
	}
}
