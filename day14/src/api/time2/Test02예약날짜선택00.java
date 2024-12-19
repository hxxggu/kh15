package api.time2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Test02예약날짜선택00 {

	public static void main(String[] args) {
		
		
		try {
			String input = "2007-05-15";
			LocalDate date = LocalDate.parse(input);
			System.out.println(date);
			
			LocalDate current = LocalDate.now();
			
			if(date.equals(current)) throw new Exception("당일 예약은 불가능합니다");
			if(date.isBefore(current)) throw new Exception("지난 날짜는 예약이 불가능합니다");
//			if(date.getDayOfWeek() == DayOfWeek.SATURDAY) throw new Exception("주말 예약은 불가능합니다");
//			if(date.getDayOfWeek() == DayOfWeek.SUNDAY) throw new Exception("주말 예약은 불가능합니다");
			String weekName = date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN);
			if(weekName.equals("토")) throw new Exception("주말 예약은 불가능합니다");
			if(weekName.equals("일")) throw new Exception("주말 예약은 불가능합니다");
			
			System.out.println("예약이 확정되었습니다");
			System.out.println("년도 : "+date.getYear());
			System.out.println("월 : "+date.getMonthValue());
			System.out.println("일 : "+date.getDayOfMonth());
		} catch(Exception e) {
//			e.printStackTrace();
			System.out.println("오류 : "+e.getMessage());
		}
	}
}
