package api.time2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Test05PC방계산기01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("시작 시간을 입력하세요 (HH:mm) : ");
		String start = sc.next();
		System.out.print("종료 시간을 입력하세요 (HH:mm) : ");
		String end = sc.next();
				
		LocalDateTime startTime = LocalDateTime.parse(start);
		LocalDateTime endTime = LocalDateTime.parse(end);
		
		Duration duration = Duration.between(startTime, endTime);		
		System.out.println(duration);
		
		int price = 1000;
		int totalPrice = (duration.toHoursPart()*price);
		if(duration.toMinutesPart() != 0) totalPrice += price;
		System.out.println("총 이용요금 : "+totalPrice+"원");
		
		
	}
}
