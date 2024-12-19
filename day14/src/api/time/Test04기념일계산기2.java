package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test04기념일계산기2 {

	public static void main(String[] args) {
		
		//입력
		int year = 2024;
		int month = 12;
		int date = 19;
		
		//기념일 계산 및 출력
		//-limit주년까지 기념일의 총 개수 cnt개
		int limit = 2;
		int cnt = 0;
		for(int i=1; i<=365*limit; i++) {
			if(i%100==0 || i%365==0) {
				cnt++;
			}
		}
//		System.out.println("cnt = "+cnt);
		
		int[] anniversaryList = new int[cnt];
		cnt = 0;
		for(int i=1; i<=365*limit; i++) {
			if(i%100==0 || i%365==0) {
				anniversaryList[cnt] = i;
				cnt++;
			}
		}
				
		Calendar c = Calendar.getInstance();
//		c.set(Calendar.YEAR, year);
//		c.set(Calendar.MONTH, month-1);
//		c.set(Calendar.DATE, date);
//		c.set(year, month-1,date);
		
		//출력
		printDate(c);
		
		for(int i=0; i<anniversaryList.length; i++) {
			c.set(year, month-1, date);
			c.add(Calendar.DATE, anniversaryList[i]);
			if(anniversaryList[i]%365 == 0) {
				System.out.print(anniversaryList[i]/365+"주년 : ");
			} else {
				System.out.print(anniversaryList[i]+"일 : ");
			} printDate(c);
		}
	}
	
	public static void printDate(Calendar c) {
		Date d = c.getTime();
		Format f = new SimpleDateFormat("y년 M월 d일 E요일");
		System.out.println(f.format(d));
	}
}
