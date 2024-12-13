package loop;

import java.util.Scanner;

public class Test07타이머 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("분 입력 : ");
		int min = sc.nextInt();
		System.out.print("초 입력 : ");
		int sec = sc.nextInt();
		
		for(int n=min; n>=0; n--) { //n은 무관
			if(n==min) {
				for(int i=sec; i>=0; i--) {
					System.out.println(n+"분"+i+"초 후 알람이 울립니다.");
					}
				} else {
				for(int m=59; m>=0; m--) { //m은 1이상 60이하
					System.out.println(n+"분"+m+"초 후 알람이 울립니다.");
				}
			}
			System.out.println("시간이 다 되었습니다!");
		}
	}
}
