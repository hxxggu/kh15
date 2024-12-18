package api.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01시간다루기 {

	public static void main(String[] args) {
		//자바에서 시간을 다루는 방법
		//1.java.lang.System 클래스
		//2.java.util.Date 클래스
		//3.java.util.Calendar 클래스
		//4.java.time 패키지
		
		//왜 이렇게 많은가? 이게 다 y2k 때문
		
		//Ex. Date 클래스
		Date a = new Date();
		Date b = new Date(124, 12, 18);
		
		System.out.println(a);
		System.out.println(b);
		
		//날짜의 출력 형식을 바꾸고 싶다면 java.text.SimpleDateFormat을 사용
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd E");
		System.out.println(fmt.format(a));
	}
}