package oop.inherit7;

public class IPhone15 extends Apple {

	public IPhone15(String num, String color) {
		super(num, color);
	}

	public void call() {
		System.out.println("IPhone15 전화 기능 실행");		
	}
	public void sms() {
		System.out.println("IPhone15 문자 기능 실행");
	}
	public void siri() {
		System.out.println("IPhone15 음성인식 기능 실행");
	}
	
	public void itunes() {
		System.out.println("IPhone15 아이튠즈 기능 실행");
	}
}
