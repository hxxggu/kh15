package loop4;

import java.util.Random;
import java.util.Scanner;

public class Test03구구단게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int life = 3;
		
		while(true) {
			int num1 = r.nextInt(8)+2;
			int num2 = r.nextInt(9)+1;
			System.out.print(num1+"X"+num2+"=");
			int userInput =  sc.nextInt();
			int answer =  num1*num2;
			if(userInput != answer) {
				life--;
				if(life == 0) {
					break;
				}
			}
		}
		System.out.println("Game Over");
	}
}
