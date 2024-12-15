package oop.multi2;

public class Kickboard extends Transportation implements Electronic {
	
	public Kickboard(int num) {
		super(num);
		if(num == 5) {
			move();
			on();
			off();
		}
	}

	public void move() {
		System.out.println("킥보드가 이동합니다");
	}

	@Override
	public void on() {
		System.out.println("킥보드의 전원을 켭니다");	
	}

	@Override
	public void off() {
		System.out.println("킥보드의 전원을 끕니다");
	}
}
