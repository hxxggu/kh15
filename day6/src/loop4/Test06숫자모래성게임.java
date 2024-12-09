package loop4;

import java.util.Scanner;

public class Test06숫자모래성게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int start = 100;
		int cnt = 0;
		
		while(true) {
			System.out.println("남은 숫자 : "+start);
			System.out.print("차감시킬 숫자 입력(1~9) : ");
			int input = sc.nextInt();
			if(1>input || input>9) { 
				System.out.println("범위 내의 숫자를 입력하십시오.(1~9 사이)");
				continue;
			}
			start -= input;
			cnt++;
			if(start <= 0) {
				break;
			}
		}
		System.out.println("당신은 패배했습니다.");
		System.out.println("총 "+cnt+"턴 동안 진행하였습니다.");
	}
}
