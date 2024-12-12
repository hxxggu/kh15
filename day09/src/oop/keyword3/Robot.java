package oop.keyword3;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Robot {
	
	
	//두 수의 곱을 구하는 메서드 구현
	public static int multiple(int a, int b) {
		return a*b;
	}
	
	public static double multiple(double a, double b) {
		return a*b;
	}
	
	//어떤 수의 제곱을 구하는 메서드 구현 (ex. Robot.squre(11) > 121)
	public static double squre(int n) {
		return Robot.multiple(n, n);
//		return n*n; //위 아래 return 둘다 가능
		//static 메서드끼리 호출 가능. 메서드명만 입력해도 가능. this 선언은 X
	}
	
	//밑변과 높이를 이용해 삼각형의 넓이를 구해주는 메서드 구현
	public static float triangle(int h, int w) {
		return (h*w)/2f;
	}
	
	//반지름이 주어졌을 때 원의 넓이를 구해주는 메서드 구현
	public static float circle(int r) {
		return r*r*3.14f;
		//return 3.14f*squre(r);
		//return multiple(3.14, squre(r));
	}
	
	//신장과 몸무게가 주어졌을 때 체질량 지수 bmi=w(kg)/(h(m)*h(m))
	public static float bmi(float h, float w) {
		return w/((h/100)*(h/100));
	}
//	public static double bmi(double cm, double kg) {
//		double m = cm/100;
//		return kg/squre(m);
//	}
	
	//출생년도 4자리가 주어졌을 때 지하철 요금을 구해주는 메서드 구현
	public static int subway(int year) {
		int current = 2024;
		int age = current-year+1;
		int deposit = 500;
		
		if(20<=age && age<65) return 1400+deposit;
		else if(14<=age && age <20) return 800+deposit;
		else if(8<=age && age<14) return 500+deposit;
		else return 0+deposit;
	}
//	public static int subway(int birth) {
//		int age = LocalDateTime.now().getYear()-birth+1;
//		if(age<8 || age>=65) return 0;
//		else if(age < 14) return 500;
//		else if(age < 20) return 800;
//		else return 1400;
//	}
}
