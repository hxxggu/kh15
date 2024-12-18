package api.lang.etc;

public class Test04래퍼클래스 {

	public static void main(String[] args) {
		//인스턴스 생성
		Integer a = new Integer(10); //비추천
		Integer b = new Integer("10"); //비추천
		Integer c = Integer.valueOf(10); //추천
		Integer d = Integer.valueOf("10"); //추천
		Integer e = 10;
		
		System.out.println(a==b); //false
		System.out.println(b==c); //false
		System.out.println(c==d); //true
		System.out.println(d==e); //true
		
		System.out.println(a.equals(b)); //true
		//int가 있는데 Integer를 왜 써야하는가?
		//: 상황에 따라 Integer가 좋은 경우가 있기 때문에
		
		//1. int가 더 좋은 상황 > 10+20의 값을 출력
		int n1 = 10;
		int n2 = 20;
		int n3 = n1+n2;
		System.out.println("n3 = "+n3);
		
		Integer m1 = Integer.valueOf(10);
		Integer m2 = Integer.valueOf(20);
		Integer m3 = Integer.sum(m1, m2);
		System.out.println("m3 = "+m3.toString());
		
		//2. Integer가 더 좋은 상황 > 100을 2진수로 바꿔서 출력
		int value = 100;
		StringBuilder builder = new StringBuilder();
		for(int i=value; i>0; i/=2) {
//			System.out.println(i%2);
			builder.insert(0, i%2);
		} 
		System.out.println("2진수 = "+builder.toString());
		System.out.println("2진수 = "+Integer.toBinaryString(value));
		
		
		System.out.println("---");
		//하이브리드
		Integer v1 = 10; //int를 자동으로 Integer로 변환(auto-boxing)
		Integer v2 = 20;
		Integer v3 = v1 + v2;
		System.out.println("v3 = "+v3);
		
		System.out.println("---");
		//(주의)int와 Integer를 반드시 구분해야 하는 경우 (null이 나올 경우)
		//void 반환값이 없음, null 참조값이 없음 (null이 나올 경우)
		//: 참조형만 쓸 수 있는 곳, null이 나올 수 있는 경우 (없을 수 있는 경우)
		//int는 참조형이 아니기 때문에 int는 null이 될 수 없음
		//int x = null;
		Integer y = null;
		
		//이전에 본 적 있는 문자열 변환 명령
		String number  = "123456";
		int change = Integer.parseInt(number);
		System.out.println("change = "+change);
		
		//상수 필드
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.BYTES);
	}
}
