package oop.constructor1;

public class Test01생성자 {

	public static void main(String[] args) {
		
//		Car a = new Car();
//		a.init("소나타", "블랙", 20000000, 200);
//		a.show();
		
		Car a = new Car("소나타", "블랙", 20000000, 200);
		a.show();
	}

}
