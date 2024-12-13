package oop.inherit7;

public class Galaxy24s extends Samsung {

	public Galaxy24s(String num, String color) {
		super(num, color);
	}
	@Override //애노테이션(annotatuion) - 바로 뒤 코드의 역할을 지정(명찰, 해시태그)
	public void call() {
		System.out.println("Galaxy24s 전화 기능 실행");
	}
	public void sms() {
		System.out.println("Galaxy24s 문자 기능 실행");	
	}
	public void samsungPay() {
		System.out.println("Galaxy24s 삼성페이 기능 실행");
	}
	public void bixby() {
		System.out.println("Galaxy24s 음성인식 기능 실행");
	}
}
