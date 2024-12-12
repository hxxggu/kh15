package oop.method6;

public class Test01핸드폰 {
	public static void main(String[] args) {
		Phone a = new Phone();
		Phone b = new Phone();
		Phone c = new Phone();
		Phone d = new Phone();
		
		a.init("갤럭시Fold6", "SK", 2200000);
		b.init("갤럭시Fold6", "KT", 2150000, 24);
		c.init("아이폰16", "LG", 2100000, 36);
		d.init("아이폰16", "SK", 2150000);
		
		a.show();
		b.show();
		c.show();
		d.show();
	}
}