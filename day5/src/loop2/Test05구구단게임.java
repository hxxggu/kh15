package loop2;

import java.util.Random;
import java.util.Scanner;

public class Test05구구단게임 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		int correct = 0, wrong = 0;
		int easyScore = 10, hardScore = 20;
		int totalScore = 0, combo  = 0;
 		
		for(int i=1; i<=10; i++) {
			int num1 = r.nextInt(8)+2;
			int	num2 = r.nextInt(9)+1;
			
			System.out.print(num1+"X"+num2+"=");
			int inputNum = sc.nextInt();
			int answer = num1*num2;
			
			if(inputNum == answer) {
				combo++;
				if(num1>6) {
					totalScore += easyScore*combo;
				} else {
					totalScore += hardScore*combo;
				}
				correct++;
			} else {
				wrong++;
				combo = 0;
			}
		}
		
		System.out.println("정답 : "+correct+"개\n오답 : "+wrong+"개");
		System.out.println("총점 : "+totalScore+"점");
	}
}
