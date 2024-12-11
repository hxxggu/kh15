package oop.method4;

public class Product {
	String name;
	String section;
	int price;
	boolean discount;
	int num;
	boolean delivery;
	
	void init(String name, String section, int price, boolean discount,int num, boolean delivery) {
		this.name = name;
		this.section = section;
		this.price = price;
		this.discount = discount;
		this.num = num;
		this.delivery = delivery;
	}
	
	void show() {
		if(discount==true && delivery==true) {
			
			System.out.print("상품명 : "+name+"");
			System.out.print("상품분류 : "+section+"");
			System.out.print("판매가 : "+price+"원 ");
			System.out.print("할인가 : "+(price*95/100)+"원 ");
			System.out.print("수량 : "+num+"");
			System.out.print("새벽 배송 : 가능");
			} else if(discount==true && delivery==false){
				System.out.print("상품명 : "+name+"");
				System.out.print("상품분류 : "+section+"");
				System.out.print("판매가 : "+price+"원 ");
				System.out.print("할인가 : "+(price*80/100)+"원 ");
				System.out.print("수량 : "+num+"");
				System.out.print("새벽 배송 : 불가능");
			} else if(discount==false && delivery==true) {
			System.out.print("상품명 : "+name+"");
			System.out.print("상품분류 : "+section+"");
			System.out.print("판매가 : "+price+"원 ");
			System.out.print("수량 : "+num+"");
			System.out.print("새벽 배송 : 가능");
			} else if(discount==false && delivery==false) {
				System.out.print("상품명 : "+name+"");
				System.out.print("상품분류 : "+section+"");
				System.out.print("판매가 : "+price+"원 ");
				System.out.print("수량 : "+num+"");
				System.out.print("새벽 배송 : 불가능");
				}
	}
}
