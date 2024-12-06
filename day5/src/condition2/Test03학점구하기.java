package condition2;

import java.util.Scanner;

public class Test03학점구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("성적을 입력하시오 : ");
		int score = sc.nextInt();
		int score2 = score/10;
		
		// switch로 구현
		switch(score2) {
		case 10: 
			System.out.println("A+");
			break;
		case 9:
			System.out.println("A");
			break;
		case 8: 
			System.out.println("B");
			break;
		case 7: 
			System.out.println("C");
			break;
		default: 
			System.out.println("F");
			break;
		}
		
		// if로 구현
		if (score==100) {
			System.out.println("A+");
		} else if(90<=score && score<100) {
			System.out.println("A");
		} else if(80<=score && score<90) {
			System.out.println("B");
		} else if(70<=score && score<80) {
			System.out.println("C");
		} else{
			System.out.println("F");
		}
	}

}
