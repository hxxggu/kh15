package condition2;

import java.util.Scanner;

public class Test03학점구하기01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int score = 95;
		int ten = score/10;
		
		switch(ten) {
		case 10:
			System.out.println("학점 : A+");
			break;
		case 9:
			System.out.println("학점 : A");
			break;
		case 8:
			System.out.println("학점  : B");
			break;
		case 7:
			System.out.println("학점 : C");
			break;
		default:
			System.out.println("학점 : F");
			break;
		}
		
	}
}
