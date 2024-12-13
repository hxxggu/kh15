package loop4;

import java.util.Scanner;

public class Test02무한입력01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int cnt = 0;
		int total = 0;
		
		while(true) {
			System.out.println("숫자 입력 (0 입력시 종료) : ");
			int num = sc.nextInt();
			
			if(num==0) {
				break;
			}
			//0이 카운트되지 않도록 탈출 조건 아래에 배치
			total += num;
			cnt++;
		}
		System.out.println("count : "+cnt);
		System.out.println("total : "+total);
		double avg = (double)total/cnt;
		System.out.println("average : "+avg);
	}
}
