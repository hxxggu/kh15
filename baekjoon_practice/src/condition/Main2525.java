package condition;

import java.util.Scanner;

public class Main2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(), B = sc.nextInt();
		int C = sc.nextInt();
			
		int hour = C/60, min = C%60;
		
		A = A+hour; B = B+min;
		
		if(A>=24) {
			A = A-24;
			if(B>=60) {
				B = B-60;
				A = A+1;
				System.out.println(A+" "+B);
			} else if(B<60) {
				System.out.println(A+" "+B);
			}
		} else if(A<24) {
			if(B>=60) {
				B = B-60;
				A = A+1;
				if(A==24) {
					A = 0;
				}
				System.out.println(A+" "+B);
			} else if(B<60) {
				System.out.println(A+" "+B);
			}
		}
	}
}