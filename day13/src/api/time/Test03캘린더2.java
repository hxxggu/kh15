package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test03캘린더2 {

	public static void main(String[] args) {
		//Calendar 인스턴스 생성
		Calendar c = Calendar.getInstance();
		
		//날짜 정보 변경
		//: 연도를 2005로 바꾸고 싶어요
		//c.setYear(2005); //우리가 배운 코드
		//c.set(1,2005); //자바 1.1 당시의 설정 코드
		c.set(Calendar.YEAR, 2005);
		//: 월을 4월로 바꾸고 싶어요 (month는 0~11로 구성되어있기 때문에 4가 아니라 3)
		c.set(Calendar.MONTH, 3);
		//: 일을 10일로 바꾸고 싶어요
		c.set(Calendar.DATE, 10); //Calendar.DATE 와 Calendar.DAY_OF_MONTH 는 같은 의미
		
		//: 연도만 추출하여 출력
		//int year = c.getYear(); //우리가 알고 있는 코드
		int year = c.get(Calendar.YEAR);
		//: 월을 추출하여 출력 (월은 0~11이므로 +1 해줘야함)
		int month = c.get(Calendar.MONTH)+1;
		
		//계산
		c.add(Calendar.DATE, 100); //100일 뒤
		
		//Date로 변환
		Date d = c.getTime();
		Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(f.format(d));
		System.out.println("연도 : "+year);
		System.out.println("월 : "+month);

	}
}