package data3;

public class Test06건강검진대상자 {
	public static void main(String[] args) {
		//Q. 국민건강검진은 한국나이 30세 이상인 사람들을 대상으로 2년마다 한번씩 무상으로 제공되는 제도.
		//짝수년도에 출생한 사람은 짝수해, 홀수년도에 출생한 사람은 홀수해에 검진을 받음
		//1980년생이 건강검진 대상자인지 판정하여 출력
		int birth=2000;
		int yearNow=2024;
		
		int age=yearNow-birth+1;
		
		boolean over30 = age>=30;
		boolean evenOdd=(birth%2==0)&&(yearNow%2==0)||(birth%2==1)&&(yearNow%2==1);
		boolean healthCare = over30&&evenOdd;
		
		//System.out.println(age); 나이
		//System.out.println(evenOdd); 짝수인지 홀수인지
		System.out.println(healthCare); //건강검진대상자인지
	}
}
