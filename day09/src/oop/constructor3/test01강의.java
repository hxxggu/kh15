package oop.constructor3;

public class test01강의 {

	public static void main(String[] args) {
		
		Subject c1 = new Subject("자바 프로그래밍 기초", "IT", 60, 50000, "온라인");
		Subject c2 = new Subject("파이썬 프로그래밍 중급", "IT", 60, 50000, "오프라인");
		Subject c3 = new Subject("정보처리기사 실기", "시험", 120, 750000, "혼합");
		
		c1.show();
		c2.show();
		c3.show();
		
	}
}
