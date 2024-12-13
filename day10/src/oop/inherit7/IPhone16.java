package oop.inherit7;

public class IPhone16 extends Apple {

	public IPhone16(String num, String color) {
		super(num, color);
	}

	public void call() {
		System.out.println("IPhone16 전화 기능 실행");	
	}
	public void sms() {
		System.out.println("IPhone16 문자 기능 실행");
	}
	public void siri() {
		System.out.println("IPhone16 음성인식 기능 실행");	
	}
	
	public void faceTime() {
		System.out.println("IPhone16 영상통화 기능 실행");
	}
}
