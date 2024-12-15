package oop.multi2;

public class Bus extends Transportation {
		
	public Bus(int num) {
		super(num);
		if(num == 2) {
			move();
		}
	}

	public void move() {
		System.out.println("버스가 이동합니다");
	}
}