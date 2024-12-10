package loop;

import java.util.Scanner;

public class Main11022 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = A+B;
			int x = i+1;
			System.out.println("Case #"+x+": "+A+" + "+B+" = "+C);
		}
	}
}