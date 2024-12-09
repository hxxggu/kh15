package loop2;

import java.util.Random;
import java.util.Scanner;

public class Test05구구단게임02 {

	public static void main(String[] args) {
		//10턴의 구구단 게임을 구현
		//: 1턴의 구구단 게임을 구현
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int correctCnt = 0, incorrectCnt = 0;
		
		int score = 0; //누적 점수
		
		//for(int i=1; i<10; i++) {} //코드 작성 시 1보다는 0부터 시작 지향
		for(int i=0; i<10; i++) {
			int left = r.nextInt(8)+2; //단
			int right = r.nextInt(9)+1; //수
			int combo = 0;
			System.out.println(left+"X"+right+"=");			
			
			int user = sc.nextInt();
			
			boolean correct = left*right == user;
			if(correct) {
				//System.out.println("정답");
				correctCnt++;
				score += 10*combo; //점수 부여(콤보 반영)
				combo++; //콤보 증가
			} else {
				//System.out.println("오답");
				incorrectCnt++;
				combo = 0; //콤보 초기화
			}
		}
		
		System.out.println("<게임 종료>");
		System.out.println("점수 : "+score);
		System.out.println("정답 개수 : "+correctCnt);
		System.out.println("오답 개수 : "+incorrectCnt);
	}
}
