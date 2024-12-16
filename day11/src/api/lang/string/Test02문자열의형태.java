package api.lang.string;

public class Test02문자열의형태 {
	public static void main(String[] args) {
		//Q. 그래서 new를 쓰는지 아닌지
		//: 자바는 new 라는 키워드가 있어야 데이터를 새로 생성
		//: 자바는 메서드를 실행하기 전에 메모리 소요량을 계산하게 되어 있음
		
		String a = "hello"; //미리 정의해둔 문자열에 연결만 하세요
		String b = "hello"; //미리 정의해둔 문자열에 연결만 하세요
		String c = new String("hello"); //문자열을 신규 생성하세요
		String d = new String("hello"); //문자열을 신규 생성하세요
		
		System.out.println(a == b); //true
		System.out.println(a == c); //false
		System.out.println(a == d); //false
		
		System.out.println(a.equals(b)); //true
		System.out.println(a.equals(c)); //true
	}
}