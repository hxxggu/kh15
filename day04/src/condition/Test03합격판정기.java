package condition;

import java.util.Scanner;

public class Test03합격판정기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수를 입력하시오 : ");
		int kor = sc.nextInt();
		System.out.print("영어 점수를 입력하시오 : ");
		int eng = sc.nextInt();
		System.out.print("수학 점수를 입력하시오 : ");
		int math = sc.nextInt();
		
		int sum = kor+eng+math;
		float avg = sum/3f;
		
		System.out.println("전과목 평균 : "+avg+"점");
		
		if((kor<40 || eng<40 || math<40) || (avg<60)) {
			System.out.println("불합격입니다.");
		} else {
			System.out.println("합격입니다.");
		}
	}
}
