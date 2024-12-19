package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test04기념일계산기 {

	public static void main(String[] args) {
		
		//입력
		int year = 2024;
		int month = 12;
		int date = 19;
		
		//기념일 계산 및 출력
		//-100일, 200일, 300일, 1주년, 400일, 500일, 600일, 700일, 2주년
		int[] anniversaryList = new int[] {
				100, 200, 300, 365, 400, 500, 600, 700, 730
		};
		
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
