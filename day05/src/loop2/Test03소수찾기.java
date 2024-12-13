package loop2;

import java.util.Scanner;

public class Test03소수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("input number : ");
		int num = sc.nextInt();
		int cnt=0;
		
		for(int i=1; i<=num; i++) { //i=나누는 수
			if(num%i == 0) {
				cnt++;
			}
		}
		
		if(cnt==2) { //cnt의 개수로 소수 판정
			System.out.println(num+"은 소수입니다.");
		} else {
			System.out.println(num+"은 소수가 아닙니다.");
		}
	}
}
