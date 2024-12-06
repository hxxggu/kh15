package loop;

import java.util.Scanner;

public class Test07타이머01 {

	public static void main(String[] args) {
		//입력
		int min = 1;
		int sec = 20;
		
		//처리
		int total = min*60+sec;
		
		try {
			//1초(1000밀리초)동안 대기
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			//인터럽트 예외 처리
			System.err.println("timer interruped.");
		}
		
		//출력
		for(int i=total; i>0; i++) {
			int m = i/60, s=i%60;
			System.out.println(m+"분 "+s+"초 남았습니다.");
		}
		System.out.println("시간이 다 되었습니다!");
	}
}
