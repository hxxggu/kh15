package oop.inherit7;

public class Test01휴대폰정보 {
	public static void main(String[] args) {
		
		Galaxy24s s1 = new Galaxy24s("242424242424", "black");
		GalaxyFold6 s2 = new GalaxyFold6("666666666", "white");
		IPhone15 a1 = new IPhone15("151515151515", "blue");
		IPhone16 a2 = new IPhone16("161616161616", "pink");
		
		s1.call();
		s1.sms();
		s1.bixby();
		s1.samsungPay();
		
		s2.call();
		s2.sms();
		s2.iris();
		s2.samsungPay();
		
		a1.call();
		a1.sms();
		a1.itunes();
		a1.siri();
		
		a2.call();
		a2.sms();
		a2.faceTime();
		a2.siri();
	}
}
