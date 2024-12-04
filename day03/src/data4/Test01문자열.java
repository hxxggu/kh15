package data4;

public class Test01문자열 {
	public static void main(String[] args) {
		//참조형 데이터(ft. 맞춤제작)
		//: 필요할 때마다 직접 만들어서 사용하는 방식
		//: 상대적으로 int, double 과 같은 원시형보다 생성이 느리다
		//: 그 대신 공간을 컴팩트하게 사용하고 원하는 구조를 만들 수 있다
		//: 리모컨과 본체의 형태를 가지므로 각종 기능을 사용할 수 있다
		
		String a="hello"; //쌍따옴표로 "원하는만큼" 글자를 감싼다
		System.out.println(a);
		System.out.println(a.length()); //글자수
		System.out.println(a.toUpperCase()); //대문자 변환

		//딱 하나의 연산(+)만 가능하다
		//: 문자열과 데이터가 더해지면 결과는 문자열이 된다
		System.out.println(a+"java"); //hellojava
		System.out.println(a+100); //hello100
		System.out.println(a+10+20); //hello1020
		
		System.out.println("a="+a); //a=hello
		
		//특수문자가 존재한다
		//: 다른 글자들과 결합하여 특수효과를 발생시킴
		//: 이스케이프 문자(escape sequence)
		//String b="나는 지금 "떡볶이"가 먹고 싶다"
		String b="나는 지금 \"떡볶이\"가 먹고 싶다"; //\"은 글자 따옴표
		System.out.println(b);
		
		
		//tab키는 컴퓨터에 정해진 가장 가까운 tab으로 이동하는 기능 (띄어쓰기 X)
		String c="사과\t\t바나나\t포도\t\t딸기"; //\t는 탭 이동
		System.out.println("c="+c);
		
		String d="사과\n바나나\n포도\n딸기\n"; //\n은 줄 바꿈
		System.out.println(d);
		
		//int e="hello"; //변환 불가능
		//int e='h'; //코드 번호가 있기에 변환 가능
	}
}
