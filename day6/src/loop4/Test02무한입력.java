package loop4;

import java.util.Scanner;

public class Test02무한입력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int total = 0;
		
		while(true) {
			System.out.print("숫자를 입력하시오 (0 입력 시 종료) : ");
			int inputNum = sc.nextInt();
			
			if(inputNum == 0) {
				break;
			}
			total += inputNum;
			cnt++;
		}
		
		double avg = (double)total/cnt;
		System.out.println("입력받은 횟수 : "+cnt);
		System.out.println("입력받은 숫자의 누적 합계 : "+total);
		System.out.println("입력받은 숫자의 누적 평균 : "+avg);
	}
}