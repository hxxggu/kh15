package loop2;

import java.util.Scanner;

public class Test02짝수홀수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int evenCnt = 0;
		int oddCnt = 0;
		
		for(int i=1; i<=10; i++) {
			System.out.print(i+"번쨰 숫자 : ");
			int num = sc.nextInt();
			
			if(num%2==0) {
				evenCnt++;
			} else {
				oddCnt++;
			}
		}
		System.out.println("짝수의 개수 : "+evenCnt+"개, 홀수 개수 :"+oddCnt+"개");
	}
}
