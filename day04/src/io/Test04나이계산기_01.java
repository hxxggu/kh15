package io;
import java.util.Scanner;

public class Test04나이계산기_01 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("출생년도 8자리를 입력하세요 : ");
		int birth = sc.nextInt();
		
		//처리
		int year = birth/10000;
		int month = birth%10000/100;
		
		int korAge = 2024-year+1;
		
		int curMon = 2024*12+12;
		int bornMon = year*12+month;
		int diff = curMon-bornMon; //개월수
		
		int ameAge = diff/12;
		
		//출력
		System.out.println("당신의 한국나이는 "+korAge+"세 입니다.");
		System.out.print("당신의 만 나이는 "+ameAge+"세 입니다.");
		System.out.println("("+diff/12+"년 "+diff%12+"개월)");
	}
}
