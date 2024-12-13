package loop4;

import java.util.Scanner;

public class Test06숫자모래성게임02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sand = 100;
		
		while(true) {
			System.out.println("남은 모래 : "+sand);
			System.out.print("가져갈 수량(1~9) 입력 : ");
			int user =  sc.nextInt();
			
			sand -= user; //모래 가져가기(숫자 차감)
			
			//탈출 조건: 남은 모래가 0인 경우
			if(sand <= 0) {
				break;
			}
		}
		System.out.println("당신은 패배했습니다.");
		System.out.println("총 ?턴 진행되었습니다.");
	}
}
