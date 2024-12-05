package io;
import java.util.Scanner;

public class Test03성적평균계산기 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		System.out.print("국어 점수를 입력하세요 : ");
		int kor = sc.nextInt();
		System.out.print("영어 점수를 입력하세요 : ");
		int eng = sc.nextInt();
		System.out.print("수학 점수를 입력하세요 : ");
		int math = sc.nextInt();
		
		//처리
		int total = kor+eng+math;
		float avg = (float)total/3;
		
		//출력
		System.out.println(name+"님의 총점 = "+total);
		System.out.println(name+"님의 평균 = "+avg);
	}
}
