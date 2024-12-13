package loop4;

import java.util.Random;
import java.util.Scanner;

public class Test04업다운게임 {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int num =  r.nextInt(1000)+1;
		while(true) {
			System.out.print("1~1000 사이 숫자를 입력하시오 : ");
			
			int input = sc.nextInt();
			if(num < input) {
				System.out.println("다운");
			} else if(num > input) {
				System.out.println("업");
			} else {
				System.out.println("정답입니다! 게임을 종료합니다.");
				break;
			}
		}		
	}
}
