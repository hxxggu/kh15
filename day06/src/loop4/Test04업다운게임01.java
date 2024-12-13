package loop4;

import java.util.Random;
import java.util.Scanner;

public class Test04업다운게임01 {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		//임의의 숫자 생성
		int answer = r.nextInt(1000)+1;
		//System.out.println("answer = "+answer);
		
		int cnt = 0;
		
		while(true) {
			//사용자가 입력
			System.out.print("정답 입력 (1~1000) : ");
			int user = sc.nextInt();
			cnt++;
			//판정
			if(answer > user) { //정답이 더 큰 경우
				System.out.println("업");
			} else if(answer < user) { //정답이 더 작은 경우
				System.out.println("다운");
			} else { //정답인 경우
				System.out.println("정답");
				break;
			}
		}
		System.out.println("게임 종료!");
		System.out.println(cnt+"회 만에 정답을 맞추셨습니다.");
	}
}
