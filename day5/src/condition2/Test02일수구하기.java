package condition2;

import java.util.Scanner;

public class Test02일수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("월 입력 : ");
		int inputMon = sc.nextInt();
		
		switch(inputMon) {
		case 1:
			System.out.println(inputMon+"월은 31일까지 있습니다.");
			break;
		case 2:
			System.out.println(inputMon+"월은 28일까지 있습니다.");
			break;
		case 3:
			System.out.println(inputMon+"월은 31일까지 있습니다.");
			break;
		case 4:
			System.out.println(inputMon+"월은 30일까지 있습니다.");
			break;
		case 5:
			System.out.println(inputMon+"월은 31일까지 있습니다.");
			break;
		case 6:
			System.out.println(inputMon+"월은 30일까지 있습니다.");
			break;
		case 7:
			System.out.println(inputMon+"월은 31일까지 있습니다.");
			break;
		case 8:
			System.out.println(inputMon+"월은 31일까지 있습니다.");
			break;
		case 9:
			System.out.println(inputMon+"월은 30일까지 있습니다.");
			break;
		case 10:
			System.out.println(inputMon+"월은 31일까지 있습니다.");
			break;
		case 11:
			System.out.println(inputMon+"월은 30일까지 있습니다.");
			break;
		case 12:
			System.out.println(inputMon+"월은 31일까지 있습니다.");
			break;
		}
	}
}