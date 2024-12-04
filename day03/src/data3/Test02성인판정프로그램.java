package data3;
import java.time.Year;

public class Test02성인판정프로그램 {
	public static void main(String[] args) {
		//Q. 2006년생이 편의점에 담배를 사러 들어왔습니다.
		//판매가 가능한지 판정하여 출력하세요 (한국나이로 20세 이상만 담배를 구매할 수 있습니다)
		int birthYear=2006;
		//int year=2024;
		int year=Year.now().getValue();
		
		int age=year-birthYear+1;
		boolean adult = age>20;
		
		System.out.println(adult);
	}
}
