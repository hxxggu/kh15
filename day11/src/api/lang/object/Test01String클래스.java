package api.lang.object;

public class Test01String클래스 {

	public static void main(String[] args) {
		//인스턴스 생성
		//String a = "hello";
		String a = new String("hello");
		
		char[] ch = new char[] {'h','e','l','l','o'};
		String b = new String(ch);
		
		byte[] by = new byte[] {104, 101, 108, 108, 111};
		String c = new String(by);
		
		System.out.println("a = "+a.hashCode()); //a = 99162322
		System.out.println("b = "+b.hashCode()); //b = 99162322
		System.out.println("c = "+c.hashCode()); //c = 99162322
		
		System.out.println("a = "+a.toString()); //a = hello
		System.out.println("b = "+b.toString()); //b = hello
		System.out.println("c = "+c.toString()); //c = hello
		
		System.out.println(a == b); //a와 b가 같습니까? (인스턴스를 비교) //false
		System.out.println(a.equals(b)); //a와 b가 같습니까? (글자를 비교) //true
		
		String d = "hello"; //문자열의 약식 생성 명령
		System.out.println(a.equals(d)); //a와 d가 같습니까? (대소문자 구분) //true
		System.out.println(a.equalsIgnoreCase(d)); //대소문자 무시하고 비교 //true
	}

}
