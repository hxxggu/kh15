package api.time;

import java.util.Calendar;
import java.util.Scanner;

public class Test05달력만들기 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("연도 : ");
		int year = sc.nextInt();
        c.set(Calendar.YEAR, year);
		System.out.println("월 : ");
		int month = sc.nextInt();
        c.set(Calendar.MONTH, month);
        Date d = c.getTime();
        Format f = new SimpleDateFormat("yyyy년 MM월");
        System.out.println(f.format(d));
        for(int i=0; i<6; i++) {
            for(int j=0; j<7; j++) {
                
                
	}
}
