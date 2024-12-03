package data;

public class Test06시간계산기 {
	public static void main(String[] args) {
		int timeHour01 = 1;
		int timeMin01 = 50;
		int timeHour02 = 2;
		int timeMin02 = 45;
		
		int hour = timeHour01+timeHour02+((timeMin01+timeMin02)/60);
		int min = (timeMin01+timeMin02)%60;
		
		System.out.println(hour+"시간"+min+"분");
		// 방법_01
		
		int h1 = 1, m1 = 50;
		int h2 = 2, m2 = 45;
		
		int t1 = h1*60+m1;
		int t2 = h2*60+m2;
		int t3 = t1+t2;
		
		int h3 = t3/60;
		int m3 = t3%60;
		
		System.out.println(h3+"시간"+m3+"분");
		// 방법_02 : 가장 작은 단위(시간을 분으로)로 변환하여 계산
	}
}
