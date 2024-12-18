package api.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Test02만나이계산기2 {
	
	public static void main(String[] args) {


		//Plan A
		String birth = "1996-06";
		
		int year = Integer.parseInt(birth.substring(0,4));
		int month = Integer.parseInt(birth.substring(5,7));
//		int month = Integer.parseInt(birth.substring(5)); //위와 아래의 month는 동일한 의미
		
		int total = year*12 + month;
		int current = LocalDateTime.now().getYear()*12 + LocalDateTime.now().getMonthValue();
		//int diff =  current - total;
		int diff = Math.abs(total-current);
		System.out.println("diff = "+diff);
		
		int age = diff/12;
		System.out.println("만 나이 = "+age);

	}

}
