package oop.inherit4;
//상속 시 주의사항
//- 필드 : 접근제한 설정
//- 생성자 : 생성자를 만들면 상속받는 하위 클래스가 무조건 따라서 만들어야 함
//- 메서드 : 원한다면 재정의(override)가 가능함
public class Phone {
	//상속과 무관하게 모두 제한(반드시 지켜야하는 설정 방식)
	//private String number;
	
	//상속받은 클래스가 자유롭게 접근(설정 방식을 하위 클래스가 결정할 수 있음)
	protected String number;
	
	//setter/getter 메서드 생략
	
	public Phone(String number) {
		this.number = number;
	}
}
