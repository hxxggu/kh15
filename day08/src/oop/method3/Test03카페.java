package oop.method3;

public class Test03카페 {

	public static void main(String[] args) {
		Cafe a = new Cafe();
		Cafe latte = new Cafe();
		Cafe cake = new Cafe();
		Cafe desert = new Cafe();
		
		a.init("아메리카노", "음료", 2500,
				
				"행사중");
		latte.init("모카라떼", "음료", 3500, "행사아님");
		cake.init("치즈케이크", "디저트", 5000, "행사중");
		desert.init("마카롱", "디저트", 3000, "행사아님");
		
		a.show();
		latte.show();
		cake.show();
		desert.show();
	}
}
