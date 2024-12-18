package api.time;

import java.beans.FeatureDescriptor;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test05달력만들기 {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("연도 : ");
		int year = sc.nextInt();
        c.set(Calendar.YEAR, year);
		System.out.print("월 : ");
		int month = sc.nextInt();
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DATE, 1);
        Date d = c.getTime();
        Format f = new SimpleDateFormat("yyyy년 MM월");
        System.out.println(f.format(d));
        
        weekday();
        
        c.set(Calendar.DAY_OF_WEEK, 1);
        
        for(int i=0; i<6; i++) {
            for(int j=0; j<7; j++) {
            	d = c.getTime();
            	f = new SimpleDateFormat("dd");
	        	System.out.print(f.format(d)+"\t");
	        	c.add(Calendar.DATE, 1);
            } System.out.println();
        }
 	}
	
	public static void weekday() {
		Calendar c = Calendar.getInstance();
		for(int i=1; i<8; i++) {
        	c.set(Calendar.DAY_OF_WEEK, i);
        	Date d = c.getTime();
        	Format f = new SimpleDateFormat("E");
    		System.out.print(f.format(d)+"\t");
        } System.out.println();
	}
}