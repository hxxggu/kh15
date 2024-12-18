package api.exception;

public class Test04예외출력 {
	//윤년 계산하는 메서드
	public static boolean isLeapYear(int year) {
		//return year%4==0 && year%100!=0 || year%400==0;
		if(year%400 == 0) return true;
		if(year%100 == 0) return false;
		if(year%4 == 0) return true;
		return false;
	}
	
	//월별 날짜수를 구해주는 메서드
	public static int getMaxDate(int year, int month) throws Exception {
		switch(month) {
		case 2: return isLeapYear(year)?29:28;
		case 4, 6, 9, 11: return 30;
		case 1, 3, 5, 7, 8, 10, 12: return 31;
		default: throw new Exception("월은 1~12만 가능합니다");
		}
	}
	
	public static void main(String[] args) {
		try {
			int year = 2000, month = 15;
			int day =  getMaxDate(year, month);
			System.out.println("날짜 수 : "+day);
		} catch (Exception e) {
			//가공된 메시지가 아닌 날 것의 예외 메시지를 보고싶다 (stack trace)
			//e.printStackTrace();
		}
	}
}
