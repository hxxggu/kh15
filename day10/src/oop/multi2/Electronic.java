package oop.multi2;

public class Electronic extends Transportation { //드론, 전동킥보드 / 핵심상속
	private int num;
	
	
	
	public void on() {
		System.out.println("의 전원을 켭니다");
	}
	
	public void off() {
		System.out.println("의 전원을 끕니다");
	}
}
