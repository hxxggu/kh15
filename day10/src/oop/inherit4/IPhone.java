package oop.inherit4;

public class IPhone extends Phone {
	
	//상위클래스 생성자를 맞춰서 생성
	public IPhone(String number) {
		super(number); //데이터 전달
	}
	
	//상위클래스의 메서드를 동일하게 한 번 더 작성한다
	public void call() {
		System.out.println("아이폰의 통화 기능 실행");
	}
}
