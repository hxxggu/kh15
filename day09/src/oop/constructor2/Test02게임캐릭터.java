package oop.constructor2;

public class Test02게임캐릭터 {

	public static void main(String[] args) {
		
		Charactor a = new Charactor("장발장", "도둑", 15, 100);
		Charactor b = new Charactor("허준", "성직자", 10, 10);
		Charactor c = new Charactor("나폴레옹", "전사", 20, 500);
		
		a.show();
		b.show();
		c.show();
	}
}
