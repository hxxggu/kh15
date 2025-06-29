package oop.basic1;

public class Test01객체지향 {
	public static void main(String[] args) {
		//내가 만들어 둔 Message의 내용대로 데이터를 하나 생성하라
		// > 인스턴스(instace) 생성(객체 생성)
		Message a = new Message();
		//a라는 이름의 리모컨(reference)를 생성하시오 : Message라는 클래스(instance) 안에 있는 변수의 호출이 가능
		
		//초기화
		a.sender = "일 잘하는 프로도";
		a.content = "언제와?";
		a.time = "오후 12:59";
		a.remain = 0;
		
		//출력
		System.out.println(a); //a는 리모컨(참조변수, reference)
		System.out.println(a.sender); //a가 참조하는 인스턴스의 sender 항목
		System.out.println(a.content); //a가 참조하는 인스턴스의 content 항목
		System.out.println(a.time); //a가 참조하는 인스턴스의 time 항목
		System.out.println(a.remain); //a가 참조하는 인스턴스의 remain 항목
		
		Message b = new Message();
		
		b.sender = "부끄러운 어피치";
		b.content = "몰라...";
		b.time = "오전 2:05";
		b.remain = 1;
		
		System.out.println(b.sender);
		System.out.println(b.content);
		System.out.println(b.time);
		System.out.println(b.remain);
	}
}
