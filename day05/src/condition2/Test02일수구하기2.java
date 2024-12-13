package condition2;

import java.util.Scanner;

public class Test02일수구하기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력
		//System.out.print("월 입력 : ");
		//int mon = sc.nextInt();
		int mon = 5;
		
		switch(mon) { //mon을 살펴보고 적절한 위치로 이동시키세요
		case 2:
			System.out.println(mon+"월은 28일까지 있습니다.");
			break;
		case 4, 6, 9, 11:
			System.out.println(mon+"월은 30일까지 있습니다.");
			break;
		default:
			System.out.println(mon+"월은 31일까지 있습니다.");
			break;
		}
	}
}