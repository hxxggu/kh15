package loop;

import java.util.Scanner;

public class Main11021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int result = A+B;
			int x = i+1;
			System.out.println("Case #"+x+": "+result);
		}
	}
}
