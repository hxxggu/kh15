package oop.keyword3;

public class Test01키워드 {

	public static void main(String[] args) {
		
		float multiple = Robot.multiple(2, 1);
		System.out.println("두 수의 곱 : "+multiple);
		
		double squre = Robot.squre(11);
		System.out.println("두 수의 제곱 : "+squre);
		
		float triangle = Robot.triangle(5, 7);
		System.out.println("삼각형의 넓이 : "+triangle+"cm2");
		
		float circle = Robot.circle(2);
		System.out.println("원의 넓이 : "+circle+"cm2");
		
		float bmi = Robot.bmi(155, 50);
		System.out.println("BMI : "+bmi);
		
		int subway = Robot.subway(2014);
		System.out.println("요금 : "+subway+"원 (보증금 500원 포함)");
	}
}
