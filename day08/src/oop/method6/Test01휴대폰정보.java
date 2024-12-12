package oop.method6;

public class Test01휴대폰정보 {

	public static void main(String[] args) {
		Mobile m1 = new Mobile();
		Mobile m2 = new Mobile();
		Mobile m3 = new Mobile();
		Mobile m4 = new Mobile();
		
		m1.init("갤럭시Fold6", "SK", 2200000);
		m2.init("갤럭시Fold6", "KT", 2150000, 24);
		m3.init("아이폰16", "LG", 2100000, 36);
		m4.init("아이폰16", "SK", 2150000);
		
		m1.setTelecom("CJ"); // 아직까지 배운 내용으로 이 코드는 거를 수 있지만
		m1.telecom = "CJ"; // 해당 코드는 걸러지지 않음 > 금일 배울 내용
		
		m1.show();
		m2.show();
		m3.show();
		m4.show();
	}

}
