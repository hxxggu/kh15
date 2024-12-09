package loop4;

import java.util.Random;
import java.util.Scanner;

public class Test03구구단게임01 {

	public static void main(String[] args) {
		//사용자에게 3번의 기회를 주는 구구단 게임 구현
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		int cnt = 0;
		
		while(true) {
			int left = r.nextInt(8)+2;
			int right = r.nextInt(9)+1;
			System.out.print(left+"X"+right+"=");
			
			int user = sc.nextInt();
			
			if(left*right == user) {
				//System.out.println("정답");
			} else {
				//System.out.println("오답");
				cnt++;
				//System.out.println("count : "+cnt);
				if(cnt == 3) {
					break;
				}
			}
		}
	}
}
