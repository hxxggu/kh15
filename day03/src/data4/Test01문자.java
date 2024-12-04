package data4;

public class Test01문자 {
	public static void main(String[] args) {
		char a=65;
		System.out.println(a);
		
		char b='A'; //글자는 외따옴표 사용
		System.out.println(b);
		
		char c='가';
		System.out.println(c);
		System.out.println((int)c); //문자형을 정수형으로 캐스트
		
		char d='힣'; //'힣'은 한글에서의 가장 마지막 문자
		System.out.println(d);
		System.out.println((int)d);
		
		//char e='hello'; //여러글자는 
		
		char e='H';
		//Q. e가 영어 대문자인지 판정하도록 코드 구현
		boolean upper = 'A'<=e && e<='Z';
		System.out.println(upper);
	}
}
