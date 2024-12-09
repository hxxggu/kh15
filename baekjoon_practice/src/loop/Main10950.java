package loop;

import java.util.Scanner;

public class Main10950 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int result = 0;
		for(int i=T; i>0; i--) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			result = num1+num2;
			System.out.println(result);
		}
	}
}
