package oop.inherit7;

public class GalaxyFold6 extends Samsung {

	public GalaxyFold6(String num, String color) {
		super(num, color);
	}
	
	public void call() {
		System.out.println("GalaxyFold6 전화 기능 실행");
	}
	public void sms() {
		System.out.println("GalaxyFold6 문자 기능 실행");	
	}
	public void samsungPay() {
		System.out.println("GalaxyFold6 삼성페이 기능 실행");
	}
	public void iris() {
		System.out.println("GalaxyFold6 홍채인식 기능 실행");
	}

}
