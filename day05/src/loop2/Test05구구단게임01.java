package loop2;

import java.util.Random;
import java.util.Scanner;

public class Test05구구단게임01 {

	public static void main(String[] args) {
		//10턴의 구구단 게임을 구현
		//: 1턴의 구구단 게임을 구현
		//: 1턴의 구구단 문제 생성
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int left = r.nextInt(8)+2; //2부터 8번째 숫자까지(2~9) 랜덤 입력
		int right = r.nextInt(9)+1; //1부터 9번째 숫자까지(1~9) 랜덤 입력
		System.out.println(left+"X"+right+"=");
		
		int user = sc.nextInt();
		
		boolean correct = left*right == user;
		if(correct) {
			System.out.println("정답");
		} else {
			System.out.println("오답");
		}
	}

}
