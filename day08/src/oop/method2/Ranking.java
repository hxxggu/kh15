package oop.method2;

public class Ranking {
	String name;
	String event;
	String season;
	int gold;
	int silver;
	int bronze;
	
	void init(String n, String e, String s, int g, int si, int b) {
		this.name = n;
		this.event = e;
		this.season = s;
		this.gold = g;
		this.silver = si;
		this.bronze = b;
	}
	
	void show() {
		System.out.print("이름 : "+this.name+"\t");
		System.out.print("종목 : "+this.event+"\t");
		System.out.print("구분 : "+this.season+"\t");
		System.out.print("금메달 : "+this.gold+"\t");
		System.out.print("은메달 : "+this.silver+"\t");
		System.out.print("동메달 : "+this.bronze+"\t");
		//추가 계산이 필요한 것들은 일회용 변수(지역변수)를 사용
		int point = (this.gold*100) + (this.silver*10)+ (this.bronze*1);
		System.out.println("랭킹 포인트 : "+point);
	}
}
