package api.lang.object;

//자바는 java.lang 패키지에 대한 import를 자동으로 해준다 (필수 패키지)
//import java.lang.Object;

public class Test01Object클래스 {
	//Object 클래스
	//: 모든 클래스의 규격을 정의하는
	//: 인스턴스는 고유한 해시코드(일련번호)를 가진다
	//: 인스턴스는 요약 정보를 출력할 수 있는 메서드를 가진다
	//: 모든 클래스는 필요에 따라 위 메서드들을 재정의할 수 있다

	public static void main(String[] args) {
		//인스턴스 생성
		Object a = new Object();
		Object b = new Object();
		
		//메서드 실행
		System.out.println("a : "+a.hashCode());
		System.out.println("b : "+b.hashCode());
		
		System.out.println("a : "+a.toString());
		System.out.println("b : "+b.toString());
		
		System.out.println(a == b); //a와 b가 같나요? (변경 불가)
		System.out.println(a.equals(b)); //a와 b가 같나요? (변경 가능)
		System.out.println(a.equals("hello"));
		System.out.println(b.equals(100));
	}
}
