package oop.modifier2;

import oop.modifier1.Student;

public class Test01공개접근 {

	public static void main(String[] args) {
		//다른 패키지(oop.modifier1)에 있는 Student의 인스턴스 생성
		//자바는 아무 설명이 없다면 패키지까지만 탐색을 한다
		//다른 패키지에 있는 것들을 사용하기 위해서는 import로 준비시켜야함
		Student a = new Student();
		
		a.init("피카츄", 50);
		
		a.show();
	}
}
