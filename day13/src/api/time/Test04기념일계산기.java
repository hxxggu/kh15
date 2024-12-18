package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test04기념일계산기 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("연도 입력 : ");
		int year = sc.nextInt();
		c.set(Calendar.YEAR, year);
		System.out.print("월 입력 : ");
		int month = sc.nextInt();
		c.set(Calendar.MONTH, month-1);		
		System.out.print("일 입력 : ");
		int day = sc.nextInt();
		c.set(Calendar.DATE, day);
			
		for(int i=100; i<=700; i+=100) {
			
			c.add(Calendar.DATE, 100);
			Date d = c.getTime();
			Format f = new SimpleDateFormat("yyyy년 MM월 dd일");
			System.out.println(i+"일 : "+f.format(d));
		}
		
		for(int i=1; i<=4; i++) {
			c.add(Calendar.YEAR, 1);
			Date d = c.getTime();
			Format f = new SimpleDateFormat("yyyy년 MM월 dd일");
			System.out.println(i+"주년 : "+f.format(d));
		}
	}
}
