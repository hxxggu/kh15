package oop.method1;

public class Test01메서드의활용 {

	public static void main(String[] args) {
		Student std1 = new Student();
		Student std2 = new Student();
		Student std3 = new Student();
		
		std1.init("홍길동", 70, 80, 90);
		std2.init("이순신", 80, 80, 90);
		std3.init("피카츄", 50, 50, 70);
		
		std1.show(); //std1을 주인공으로 해서 show 메서드의 코드를 실행하시오.
		std2.show(); //std2을 주인공으로 해서 show 메서드의 코드를 실행하시오.
		std3.show(); //std3을 주인공으로 해서 show 메서드의 코드를 실행하시오.
	}
}
