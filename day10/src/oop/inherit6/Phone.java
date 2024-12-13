package oop.inherit6;

//상위 클래스를 만들 때 불편사항?
//1. 인스턴스 생성이 안돼야하지만 된다 (클래스니까)
//2. 내용 구현하기가 애매한 메서드가 발생한다
// >> abstract 키워드를 클래스와 메서드에 붙여서 해결
// >> 재정의 강제 키워드
public abstract class Phone {
	public abstract void call();
	public abstract void sms();
	public abstract void internet();
}
