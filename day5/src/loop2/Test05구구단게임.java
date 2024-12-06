package loop2;

import java.util.Random;
import java.util.Scanner;

public class Test05구구단게임 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		
		int correct = 0, wrong =0;
		
		for(int i=0; i<10; i++) {
			int num1 = r.nextInt(8)+2;
			int	num2 = r.nextInt(9)+1;
			
			System.out.print(num1+"X"+num2+"=");
			int answer = sc.nextInt();
			if(answer == num1*num2) {
				correct++;
			} else {
				wrong++;
			}
		}
		
		System.out.println("정답 : "+correct+"개, 오답 : "+wrong+"개");
	}
}
