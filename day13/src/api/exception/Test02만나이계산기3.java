package api.exception;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Test02만나이계산기3 {
	
	public static void main(String[] args) {


		try {//Plan A
				Scanner sc = new Scanner(System.in);
				System.out.print("생년월일(YYYY-MM-DD) 입력 : ");
				String birth = sc.next();
				
				//강제처리1 - 길이 검사
//				if(birth.length() != 7) throw new Exception("올바른 글자수가 아닙니다");
				if(!birth.matches("^[0-9]{4}-[0-9]{2}$")) throw new Exception("올바른 생년월일 형식이 아닙니다");
				
				int year = Integer.parseInt(birth.substring(0,4));
				//강제처리2 - 연도가 1900 미만인 경우를 차단
				if(year < 1900) throw new Exception("1900 미만은 연도로 설정할 수 없습니다");
				int month = Integer.parseInt(birth.substring(5,7));
				//강제처리3 - 월이 1~12 사이가 아닌 경우 차단
				if(month<1 || month>12) throw new Exception("월은 1~12로만 작성 가능합니다");
				int date = Integer.parseInt(birth.substring(8,10));
				int maxDate = getMaxDate(year, month); //연/월에 따른 날짜 수 계산
//				int month = Integer.parseInt(birth.substring(5)); //위와 아래의 month는 동일한 의미
				
				int total = getTotalDate(year, month, date);
				int current = getTotalDate(2024, 12, 18); //금일 날짜
//				int current = LocalDateTime.now().getYear()*12 + LocalDateTime.now().getMonthValue();
				//강제처리4 - 미래의 날짜를 입력한 경우
				if(current < total) throw new Exception("미래의 날짜는 입력할 수 없습니다");
				//int diff =  current - total;
				int diff = Math.abs(total-current);
				System.out.println("diff = "+diff);
				
				int age = diff/365; //365일 당 한 살
				System.out.println("만 나이 = "+age);
		} catch(Exception e) {
			if(e.getMessage() == null) System.err.println("프로그램 실행 중 오류가 발생했습니다");
			else System.err.println("오류 : "+e.getMessage());
		}

	}
	
	//일회용 메서드
	public static int getMaxDate(int year, int month) {
		boolean leap = year%4==0 && year%100!=0 || year%400==0; //윤년 판단 공식
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12: return 31;
		case 4, 6, 9, 11: return 30;
		default:
			if(leap) return 29;
			else return 28;
		}
	}
	
	//연+월+일을 모두 일로 바꿔서 반환하는 기능
	public static int getTotalDate(int year, int month, int date) {
		int total  = 0;
		total += (year-1)*365; //작년까지 연도를 일로 바꿈
		switch(month-1) { //전달까지만 합산
		case 12: total += getMaxDate(year, 12); //12월의 일수
		case 11: total += getMaxDate(year, 11); //11월의 일수
		case 10: total += getMaxDate(year, 10); //10월의 일수
		case 9: total += getMaxDate(year, 9); //9월의 일수
		case 8: total += getMaxDate(year, 8); //8월의 일수
		case 7: total += getMaxDate(year, 7); //7월의 일수
		case 6: total += getMaxDate(year, 6); //6월의 일수
		case 5: total += getMaxDate(year, 5); //5월의 일수
		case 4: total += getMaxDate(year, 4); //4월의 일수
		case 3: total += getMaxDate(year, 3);//3월의 일수
		case 2: total += getMaxDate(year, 2);//2월의 일수
		case 1: total += getMaxDate(year, 1);//1월의 일수
		}
		total += date-1; //금일 전날까지만 계산
		return total;
	}
	

}
