package oop.method5;

public class Test01세터게터메서드 {
	public static void main(String[] args) {
		Student s = new Student();
		
		s.init("피카츄", 60, 70, 80);
		//Q. 국어 점수만 변경?
		//s.init("피카츄", -70, 70, 80); //init을 쓰면 다 바꿔야하고
		//s.kor = -70; //필드에 직접 접근하면 필터링이 안됨
		s.setKor(-70);
		
		s.show();
	}
}

