package loop4;

import java.util.Random;

public class Test01무한반복 {

	public static void main(String[] args) {
		//while 반복문
		//: for처럼 같은 코드를 여러번 실행할 수 있는 구문
		//: while(조건) { 코드 }
		
	
		//1부터 10까지 while로 출력
		//int n = 1;
		//while(n <= 10) {
			//System.out.println("n = "+n);
			//n++;
		//}
		
		//while(true)를 사용하면 무한대로 실행하는 반복문이 만들어짐
		//: 하지만 프로그램은 언젠가 끝나야하므로 해당 시점을 찾아 break
		
		//Ex. 주사위에서 6이 나올 때까지 던지는 프로그램
		Random r = new Random();
		while(true) {
			int dice = r.nextInt(6)+1;
			System.out.println("dice : "+dice);
			
			//탈출 조건
			if(dice==6) {
				break;
			}
		}
	}
}
