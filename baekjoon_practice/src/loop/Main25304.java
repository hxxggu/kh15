package loop;

import java.util.Scanner;

public class Main25304 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x =  sc.nextInt(); //총 금액
		int n = sc.nextInt(); //구매한 물건의 종류의 수
		
		int total = 0;
		
		for(int i=n; i>0; i--) {
			int a = sc.nextInt(), b = sc.nextInt(); //물건의 가격 a와 개수 b
			total += (a*b);
		}
		
		if(total == x) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
