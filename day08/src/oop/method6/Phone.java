package oop.method6;

public class Phone {
	String name;
	String company;
	int price;
	int term;
	
	void init(String name, String company, int price) { //약정개월 X
		this.setName = name;
		this.company = company;
		this.price = price;
	}
	
	void init(String name, String company, int price, int term) { //약정개월 O
		this.name = name;
		this.setCompany(company);
		this.setPrice(price);
		this.setTerm(term);
	}
	void setName(String name) {
		this.name = name;
	}
	
	void setCompany(String company) {
		if(company!="SK") {
			return;
		} else if(company!="KT") {
			return;
		} else if(company!="LG") {
			return;
		} else if(company!="알뜰폰") {
			return;
		}
	}
	
	void setPrice(int price) {
		if(0>price) {
			return;
		}
		this.price = price;
	}
	
	void setTerm(int term) {
		if(term != 0) {
			return;
		} else if(term != 24) {
			return;
		} else if(term != 30) {
			return;
		} else if(term != 36) {
			return;
		}
	}
	
	int getPrice() {
		return this.price;
	}
	
	int getMonth() {
		
	}
	
	
	
	void show() {
		if(term == true) {
			System.out.println("이름 : "+this.name);
			System.out.println("통신사 : "+this.company);
			System.out.println("가격 : "+this.price);
			System.out.println("약정 개월 : "+this.term);
			System.out.println("월 분납금 : ");
		} else {
			System.out.println("이름 : "+this.name);
			System.out.println("통신사 : "+this.company);
			System.out.println("가격 : "+this.price);
			System.out.println("약정 개월 : 미설정");
		}
	}
	
}
