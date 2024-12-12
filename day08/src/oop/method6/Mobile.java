package oop.method6;

public class Mobile {
	//멤버 필드
	String name;
	String telecom;
	int price;
	int period;
	
	// Setter/Getter 먼저 만들기
	// 멤버필드의 개수만큼 setter와 getter의 개수가 필수로 필요함
	
	void setName(String name) {
		this.name = name;
	}
	void setTelecom(String telecom) {
		if(telecom!="SK" && telecom!="KT" && telecom!="LG" && telecom!="알뜰폰") {
			return;
		}
		this.telecom = telecom;
	}
	
//	방법 2.
//	void setTelecom(String telecom) {
//		if(telecom =="SK" || telecom=="KT" || telecom=="LG" || telecom!="알뜰폰") {
//			this.telecom = telecom;
//		}
//	}
	
//	방법 3.
//	void setTelecom(String telecom) {
//		switch(telecom) {
//		case "SK":
//		case "LG":
//		case "KT":
//		case "알뜰폰":
//		this.telecom = telecom;
//		}
//	}
//	: 원래 문자열을 비교하기 위해서는 switch를 사용
	
	void setPrice(int price) {
		if(price < 0) return;
		this.price = price;
	}
	void setPeriod(int period) {
		switch(period) {
		case 0, 24, 30, 36:
			this.period = period;
		}
	}
	
	String getName() {
		return this.name;
	}
	String getTelecom() {
		return this.telecom;
	}
	int getPrice() {
		return this.price;
	}
	int getPeriod() {
		return this.period;
	}
	int getMonthPrice() {
		return this.price / this.period;
	}
	
	void init(String name, String telecom, int price) {
		this.init(name, telecom, price, 0);
	}
	void init(String name, String telecom, int price, int period) {
		this.setName(name);
		this.setTelecom(telecom);
		this.setPrice(price);
		this.setPeriod(period);
	}
	
	boolean isContact() {
		return this.period > 0;
	}
	
	void show() {
		System.out.println("< 휴대폰 정보 >");
		System.out.println("이름 : " + this.getName());
		System.out.println("통신사 : " + this.getTelecom());
		System.out.println("판매가 : " + this.getPrice() + "월");
		if(this.isContact()) {
			System.out.println("약정 개월 : " + this.getPeriod());
			System.out.println("월 분납금 : " + this.getMonthPrice() + "원");			
		}
	}
}
