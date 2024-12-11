package oop.method2;

public class Test02 {

	public static void main(String[] args) {
		Ranking first = new Ranking();
		Ranking second = new Ranking();
		Ranking third = new Ranking();
		
		first.init("전종오", "사격", "하계", 4, 2, 0);
		second.init("김수녕", "양궁", "하계", 4, 1, 1);
		third.init("전이경", "쇼트트랙", "동계", 4, 0, 1);
		
		first.show();
		second.show();
		third.show();
	}
}