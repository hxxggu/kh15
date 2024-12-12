package oop.constructor3;

public class Test01강의정보 {

	public static void main(String[] args) {
	
		Lecture a = new Lecture("자바 프로그래밍 기초", "IT", 60, 50000, "온라인");
		Lecture b= new Lecture("파이썬 프로그래밍 중급", "IT", 90, 100000, "오프라인");
		Lecture c = new Lecture("정보처리기사 실기", "시험", 120, 100000, "혼합");
		
		a.show();
		b.show();
		c.show();
	}

}
