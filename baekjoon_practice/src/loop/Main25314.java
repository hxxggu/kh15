package loop;

import java.util.Scanner;

public class Main25314 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		
		for(int j=N; j>0; j--) {
			if(j%4 == 0) {
				cnt++;
			}
		}
		for(int i=cnt; i>0; i--) {
			System.out.print("long ");
		}
		System.out.print("int");
	}
}