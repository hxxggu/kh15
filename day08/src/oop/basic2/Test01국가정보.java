package oop.basic2;

public class Test01국가정보 {

	public static void main(String[] args) {
		//4개의 국가 정보(instance)를 생성
		
		Nation a = new Nation();
		Nation b = new Nation();
		Nation c = new Nation();
		Nation d = new Nation();
		
		a.name = "한국";
		a.capital = "서울";
		a.size = 50000000;
		
		b.name = "일본";
		b.capital = "도쿄";
		b.size = 120000000;

		c.name = "중국";
		c.capital = "베이징";
		c.size = 1400000000;
		
		d.name = "한국";
		d.capital = "서울";
		d.size = 250000000;
		
		System.out.println("이름 : "+a.name);
		System.out.println("수도 : "+a.capital);
		System.out.println("인구 : "+a.size);
		
		System.out.println("이름 : "+b.name);
		System.out.println("수도 : "+b.capital);
		System.out.println("인구 : "+b.size);
		
		System.out.println("이름 : "+c.name);
		System.out.println("수도 : "+c.capital);
		System.out.println("인구 : "+c.size);
		
		System.out.println("이름 : "+d.name);
		System.out.println("수도 : "+d.capital);
		System.out.println("인구 : "+d.size);
	}
}
