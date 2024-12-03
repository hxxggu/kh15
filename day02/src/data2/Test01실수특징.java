package data2;

public class Test01실수특징 {

	public static void main(String[] args) {
		//실수
		//: 소수점이 있는 숫자
		//: float, double 이라는 형태가 존재 (자리수 표현 크기)
		//: 별다른 표시가 없다면 double 기본형태
		//: 부정확함
		//: [중요] 실수가 포함된 계산의 결과는 실수이다
		
		double a = 1.524526247235424;
		System.out.println(a);
		
		float b = 1.524526247235424f;
		System.out.println(b);
		
		float c = 100;
		System.out.println(c);
		
		System.out.println(10/3);
		System.out.println(10/3.0);
		System.out.println(10/3f);
	}
}
