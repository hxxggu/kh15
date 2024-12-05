package io;
import java.util.Scanner;

public class Test05ABMI계산기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("신장을 입력하시오 : ");
		float hCm = sc.nextFloat();
		System.out.print("몸무게를 입력하시오 : ");
		float w = sc.nextFloat();
		float hM = hCm/100;
		
		float bmi = w/(hM*hM);
		boolean result = bmi>=24.5f;
		
		System.out.println("키 : "+hCm+"cm");
		System.out.println("몸무게 : "+w+"kg");
		System.out.println("BMI 수치 : "+bmi);
		System.out.println("과체중 여부 : "+result);
	}
}