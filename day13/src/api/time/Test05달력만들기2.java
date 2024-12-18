package api.time;

import java.beans.FeatureDescriptor;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test05달력만들기2 {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		
        c.set(Calendar.YEAR, 2024);
        c.set(Calendar.MONTH, 9);
        c.set(Calendar.DATE, 1);
        
        Date d = c.getTime();
        Format f = new SimpleDateFormat("yyyy년 MM월");
        System.out.println(f.format(d));
 
        for(int i=1; i<8; i++) {
        	c.set(Calendar.DAY_OF_WEEK, i);
        	d = c.getTime();
        	f = new SimpleDateFormat("E");
    		System.out.print(f.format(d)+"\t");
        } System.out.println();
                
        for(int i=0; i<6; i++) {
            for(int j=0; j<7; j++) {
            	
            	
	        	d = c.getTime();
	        	f = new SimpleDateFormat("dd");
	        	System.out.print(f.format(d)+"\t");
	        	c.add(Calendar.DATE, 1);
            } System.out.println();
        }
	}
}