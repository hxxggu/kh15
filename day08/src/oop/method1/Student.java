package oop.method1;

//학생 클래스
public class Student {
	//멤버 필드
	String name;
	int kor, eng, math;
	
	// 어차피 인스턴스가 생기면 "초기화"와 "출력" 기능이 필요
	// 당연한 기능이라면 미리 준비할 수 있는가?
	//  -> 멤버 메소드
	
	// void 이름(준비물) { (: 준비물이 필요한 메서드도 있고 아닌 메서드도 있음)
	//  코드
	// }
	
	// 이 메서드는 데이터 4개를 넣어야 실행됨
	// 초기화
	void init(String n, int k, int e, int m) { //준비물 = 매개변수(매개가 되는 변수)
		this.name = n;
		this.kor = k;
		this.eng = e;
		this.math = m;
	}
	
	void show() {
		// this == 주인공
		System.out.println("이름 : "+this.name);
		System.out.println("국어 : "+this.kor);
		System.out.println("영어 : "+this.eng);
		System.out.println("수학 : "+this.math);
		int total = this.kor+this.eng+this.math;
		System.out.println("총점 : "+total);
	}
}
