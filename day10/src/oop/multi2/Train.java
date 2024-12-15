package oop.multi2;

public class Train extends Transportation implements Reserve {

	public Train(int num) {
		super(num);
		if(num == 4) {
			move();
			reservation();
		}
	}

	public void move() {
		System.out.println("기차가 이동합니다");
	}
	
	@Override
	public void reservation() {
		System.out.println("기차를 예약합니다");
	}
}
