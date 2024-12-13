package loop4;

import java.util.Random;
import java.util.Scanner;

public class Test05베스킨라빈스게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		int cnt = 1;

		for(int i=1; i<=31; i++) {
			System.out.println("현재 차례 : "+cnt);
			System.out.print("선택할 숫자의 개수(1~3) : ");
			int num = sc.nextInt();
			cnt += num;
			
			System.out.println("현재 차례 : "+cnt);
			num = r.nextInt(3)+1;
			System.out.println("선택할 숫자의 개수(1~3) : "+num);
			cnt += num;
			if(cnt >= 31) {
				System.out.println("당신은 패배했습니다!");
				break;
			}
		}
	}
}
