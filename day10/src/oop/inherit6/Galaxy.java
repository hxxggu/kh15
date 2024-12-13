package oop.inherit6;
//override 만들다가 만 메서드를 생성
public class Galaxy extends Phone {
//Phone이라는 클래스는 "틀"만 잡아줌
	public void call() {
		System.out.println("갤럭시의 전화기능 실행");
	}
	public void sms() {
		System.out.println("갤럭시의 문자기능 실행");
	}
	public void internet() {
		System.out.println("갤럭시의 인터넷기능 실행");
	}
}
