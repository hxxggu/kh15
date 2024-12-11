package oop.method4;

public class Test01상품 {

	public static void main(String[] args) {
		Item a = new Item();
		Item b = new Item();
		Item c = new Item();
		Item d = new Item();
		
		a.init("비김면", "라면", 16800, 2, 0, true);
		b.init("크림대빵", "제과", 6500, 2);
		//b.init("크림대빵", "제과", 6500, 2, 0, false);
		c.init("점보도시락", "라면", 8500, 3, 5, true);
		d.init("공간춘", "라면", 12300, 3, 20);
		//d.init("공간춘", "라면", 12300, 3, 20, false);
		
		a.show();
		b.show();
		c.show();
		d.show();
	}

}
