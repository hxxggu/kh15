package oop.multi1;

//인터페이스 (interface)
//: 다중상속 전용 클래스
//: 다중상속 시 문제가 되는 모든 요소를 제거했음
//: public 접근 제한만 가능함
public interface Singer {
	//: 필드 생성 불가 (상수만 생성 가능)
	//private String name;
	
	//: 생성자 생성 불가
	//public Singer(){}
	
	//: 메서드는 추상 메서드만 생성 가능
	/*public abstract*/ void sing(); //앞의 public abstract 가 없어도 자동으로 있다고 인식
	
}