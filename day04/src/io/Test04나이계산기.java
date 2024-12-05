package io;
import java.util.Scanner;

public class Test04나이계산기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("생년월일 8자리 입력 : ");
		int birth = sc.nextInt();
		System.out.println("생년월일 : "+birth);
		
		int yearCur = 2024;
		int monCur = 12;
		
		int year = birth/10000;
		System.out.println("년 : "+year);
		int month =birth%10000/100;
		System.out.println("달 : "+month);
		int day = birth%100;
		System.out.println("일 : "+day);
		
		int korAge = yearCur-year+1;
		int age = (((yearCur*12)+monCur)-((year*12)+month))/12;
		
		System.out.println("당신의 한국나이 : "+korAge+"세");
		System.out.println("당신의 만 나이 : "+age+"세");
		System.out.println("입력한 생년월일 : "+year+"년"+month+"월"+day+"일");
	}
}
