package data3;

import java.time.LocalDate;

public class Test03만나이계산기_02 {
	public static void main(String[] args) {
		//만 나이는 태어난 시기를 기준으로 현재까지 살아온 기간을 이용하여 계산합니다
		//12개월 당 1살로 가정. 2016년 3월생의 만 나이를 구하여 출력, 주민등록증 발급 가능한 나이(만 18세 이상)인지 판정하여 출력
		
		//입력
		int y = 2016, m = 3;
		
		//처리
		int t = y*12+m;
		int now = LocalDate.now().getYear()*12+LocalDate.now().getMonthValue();
		
		int gap = now-t;
		int age = gap/12;
		boolean vote = age>=18;
		
		//출력
		System.out.println(y+"년 "+m+"월생의 만 나이는 "+age+"살입니다.");
		
		boolean ableAge = age > 18;
		System.out.println(vote);
	}
}