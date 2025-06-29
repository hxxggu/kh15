package api.time2;

import java.time.Duration;
import java.time.LocalTime;

public class Test04시간제어 {
	public static void main(String[] args) {
		//인스턴스 생성
		
		LocalTime a = LocalTime.now();
		LocalTime b = LocalTime.of(18, 30);
		LocalTime c = LocalTime.parse("18:30");
		
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		System.out.println("c = "+c);
		
		//정보 추출
		System.out.println("a의 시간정보 = "+a.getHour());
		
		//퇴근까지 남은 시간 계산
		Duration duration = Duration.between(a, b);
		System.out.println("Duration = "+duration);
		System.out.println(duration.toDaysPart());
		System.out.println(duration.toHoursPart());
		System.out.println(duration.toMinutesPart());
		System.out.println(duration.toSecondsPart());
		
		System.out.println("퇴근까지 "+duration.toHoursPart()+"시간 "+duration.toMinutesPart()+"분 "+duration.toSecondsPart()+"초 남았습니다");
	}
}
