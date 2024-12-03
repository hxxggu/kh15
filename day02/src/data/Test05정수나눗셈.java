package data;

public class Test05정수나눗셈 {
	public static void main(String[] args) {
		//정수에서의 나눗셈 특징
		// - 정수끼리 계산하면 정수가 나온다
		// - 따라서 나눗셈은 몫과 나머지 구하는 방법이 다르다
		
		//Ex. 150분은 몇 시간 몇 분인가요?
		
		int time = 150;
		int onehour = 60;
		int hour = time / onehour;
		int min = time % onehour;
		
		System.out.println(time+"분은 "+hour+"시간"+min+"분입니다.");
	}
}
