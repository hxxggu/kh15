package loop5;

import java.util.Scanner;

public class Test01선실행후반복 {

	public static void main(String[] args) {
		//do-while 반복문
		//: 먼저 실행하고 반복하지 말지를 나중에 검사하는 형태의 반복문
		
		
		//(ex)사용자에게 점수(0~100)를 정상적으로 입력할 때까지 입력받기
		Scanner sc = new Scanner(System.in);
		
		int score;
		do {
			System.out.print("점수 입력 : ");
			score = sc.nextInt();
		} while(score<0 || score >100);
	}
}
