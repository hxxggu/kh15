package condition;

import java.util.Scanner;

public class Test02지각판정기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입실 시각 : ");
		int time = sc.nextInt();
		
		int hour = time/100;
		int min = time%100;
		
		if(hour<=9 && min<41) {
			System.out.print("정상 출석입니다.");
		} else {
			System.out.print("지각입니다.");			
		}
	}
}
