package loop4;

import java.util.Random;
import java.util.Scanner;

public class Test05베스킨라빈스게임01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = 1;
		
		while(true) {
			System.out.println("현재 숫자 : "+num);
			System.out.print("선택할 개수 입력(1~3) : ");
			int user = sc.nextInt();
			//(+추가) 1~3이 아니면 다시 시작하도록 처리
			if(user<1 || user>3) {
				continue; //다음 바퀴로 점프
			}
			//(+추가) 선택한 숫자 개수만큼의 출력을 추가
			for(int i=num; i<num+user; i++) {
				System.out.print(i+" ");
			} System.out.println("선택 완료");
			
			num += user;
			
			//탈출 조건 : 31을 선택하면 = num가 31보다 크면
			if(num>31 && num==31) {
				break;
			}
		}
		//while문의 한 턴을 게임의 한 회전으로 생각하기 때문에
		//결론에 대한 출력은 반복문 바깥에 두는 것 지향
		System.out.println("당신은 패배했습니다.");
	}
}
