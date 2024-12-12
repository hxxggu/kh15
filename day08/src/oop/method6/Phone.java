package oop.method6;

public class Phone {
	String name;
	String company;
	int price;
	int term;
	
	void init(String name, String company, int price) {
		this.init(name, company, price, 0);
	}
	
	void init(String name, String company, int price, int term) {
		this.setName(name);
		this.setCompany(company);
		this.setPrice(price);
		this.setTerm(term);
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	void setCompany(String company) {
		if(company!="SK" && company!="KT" && company!="LG" && company!="알뜰폰") {
			return;
		}
		this.company = company;
	}
	
	void setPrice(int price) {
		if(0 > price) {
			return;
		}
		this.price = price;
	}
	
	void setTerm(int term) {
		if(term!=0 && term!=24 && term!=30 && term!=36) {
			return;
		}
		this.term = term;
<<<<<<< HEAD
=======
	}
	
	String getName() {
		return this.name;
	}
	
	String getCompany() {
		return this.company;
>>>>>>> branch 'main' of https://github.com/hxxggu/kh15.git
	}
	
	String getName() {
		return this.name;
	}
	
	String getCompany() {
		return this.company;
	
	int getPrice() {
		return this.price;
	}
	
	int getTerm() {
		return this.term;
	}
	
	float getPay() {
		return (float)this.getPrice()/this.getTerm();
	}
		
	void show() {
		System.out.println("[ 기기 정보 ]");
		System.out.println("이름 : "+this.getName());
		System.out.println("통신사 : "+this.getCompany());
		System.out.println("가격 : "+this.getPrice()+"원");
		if(this.getTerm() != 0) {
			System.out.println("약정 개월 : "+this.getTerm()+"개월");
			System.out.println("월 분납금 : "+this.getPay()+"원");
			} else {
				System.out.println("약정 개월 : 미설정");
			}
<<<<<<< HEAD
		}
=======
>>>>>>> branch 'main' of https://github.com/hxxggu/kh15.git
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> branch 'main' of https://github.com/hxxggu/kh15.git
