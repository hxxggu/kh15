package api.time;

import java.util.Calendar;

public class Test05달력만들기 {

	public static void main(String[] args) {
		//연, 월을 입력받아 달력 보여주기
		int year = 2024;
		int month = 11;
		
		//구해야 하는 정보
		//- 주어진 달의 1일이 무슨 요일인가
		//- 1일에서 몇일 전으로 이동해야 하는가
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, 1); //해당 달의 시작일로 설정
		int week = c.get(Calendar.DAY_OF_WEEK); //DAY_OF_WEEK : 요일 표시(1:일, 2:월, 3:화 ,,,)
//		System.out.println("week = "+week);
		
		c.add(Calendar.DATE, -week+1); //달력의 시작지점(일요일)으로 이동
				
		//출력
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for(int i=0; i<42; i++) {
			System.out.print(c.get(Calendar.DATE));
			System.out.print("\t");
			
			c.add(Calendar.DATE, 1); //하루 뒤로 이동
			
			if(i%7 == 6) {
				System.out.println();
			}
		}
	}
}
