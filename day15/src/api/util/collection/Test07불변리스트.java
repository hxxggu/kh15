package api.util.collection;

import java.util.Arrays;
import java.util.List;

public class Test07불변리스트 {
	public static void main(String[] args) {
		
		//원래 List는 가변 (= 데이터가 늘었다 줄었다 할 수 있음을 의미)
		//하지만 원한다면 불변 리스트를 생성할 수 있음
		//불변 리스트는 데이터 추가나 삭제 X, 오로지 읽기만 가능
		//변하지 않는 초기데이터를 저장할 때 배열 대신 사용
		
		//Java 8
		List<String> a = Arrays.asList("피카츄", "파이리", "라이츄");
		
		System.out.println(a.getClass()); //a의 자료형 확인
		//class java.util.Arrays$ArrayList ($: 중첩클래스를 의미)
		System.out.println(a);
		
		
		//Java9+
		List<String> b = List.of("피카츄", "파이리", "라이츄");
		System.out.println(b.getClass());
		System.out.println(b);
		
		//추가/삭제가 불가능
//		a.add("꼬부기"); //예외발생
//		a.remove("피카츄"); //예외발생
//		b.add("꼬부기"); //예외발생
//		b.remove("피카츄") //예외발생
		
		List<String> c = b.subList(0, 2);
		System.out.println(c.getClass());
		System.out.println(c);
		
		
	}
}
