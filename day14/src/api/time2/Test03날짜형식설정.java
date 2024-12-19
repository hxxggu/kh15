package api.time2;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Test03날짜형식설정 {

	public static void main(String[] args) {
		//날짜의 형식이 yyyy-MM-dd 가 아닐 경우 처리하는 방법
		
		String str = "19/12/2024";
//		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 아래와 동일
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(str, fmt); //fmt에 기반해서 읽어라
		
		System.out.println("date = "+date);
		System.out.println("date = "+date.format(fmt));
//		System.out.println("date = "+fmt.format(date));
	}
}
