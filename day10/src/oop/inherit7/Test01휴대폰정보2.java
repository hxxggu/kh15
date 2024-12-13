package oop.inherit7;

public class Test01휴대폰정보2 {
	public static void main(String[] args) {
		
		Phone s1 = new Galaxy24s("242424242424", "black");
		Phone s2 = new GalaxyFold6("666666666", "white");
		Phone a1 = new IPhone15("151515151515", "blue");
		Phone a2 = new IPhone16("161616161616", "pink");
		//상속인 경우에만 가능함 (클래스명 >> 상위메서드)
		//but, 상위메서드 안을 제외한 하위의 고유메서드들의 기능은 사용할 수 없다
		
		s1.call();
		s1.sms();
//		s1.bixby();
//		s1.samsungPay();
		
		s2.call();
		s2.sms();
//		s2.iris();
//		s2.samsungPay();
		
		a1.call();
		a1.sms();
//		a1.itunes();
//		a1.siri();
		
		a2.call();
		a2.sms();
//		a2.faceTime();
//		a2.siri();
	}
}
