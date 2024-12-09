package loop4;

import java.util.Scanner;

public class Test06숫자모래성게임01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sand = 100;
		int turn = 0;
		
		while(true) {
			System.out.println("남은 모래 : "+sand);
			System.out.print("가져갈 수량(1~9) 입력 : ");
			int user =  sc.nextInt();
			//(참고) 어떤 구문에 중괄호가 없다면 딱 한줄만 구문에 포함된다
			if(user<1 || user >9) continue;
			
			turn++; //턴 카운트 증가
			sand -= user; //모래 가져가기(숫자 차감)
			
			//탈출 조건: 남은 모래가 0인 경우
			if(sand <= 0) {
				break;
			}
		}
		System.out.println("당신은 패배했습니다.");
		System.out.println("총 "+turn+"턴 진행되었습니다.");
	}
}
