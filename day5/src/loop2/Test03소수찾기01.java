package loop2;

import java.util.Scanner;

public class Test03소수찾기01 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		int cnt = 0;
		
		//처리
		boolean flag = true;
		for(int i=1; i<=num; i++) {
			if(num%i==0) {
			//System.out.println(num+"%"+i+"="+num%i);
				cnt++;
			//(추가) num가 되기 전에 카운트가 2 이상이면 더 볼 필요 없다
				if(i<num && cnt>=2) {
					flag = false;
					break; //이 구문을 나가라
				}
			}
		}
		
		//출력
		//System.out.println("0이 나온 횟수 : "+cnt);
		if(flag) {
				System.out.println("소수입니다");
		} else {
				System.out.println("소수가 아닙니다.");
		}
	}	
}
