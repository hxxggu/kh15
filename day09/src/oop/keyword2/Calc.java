package oop.keyword2;

public class Calc {
	//static은 반 객체지향 키워드
	//: 인스턴스까지 만들어서 관리할 필요가 없는 일회용 변수, 메서드에 작성
	//: 클래스 이름과 대상의 이름으로 접근이 가능(아무데서나 가능)
	//: 메모리를 계속 점유하고 있어 많을수록 부하가 심해짐
	
	public static int getPlus(int left, int right) {
		return left+right;
	}
	
	public static int minus(int left, int right) {
		return left-right;
	}
}