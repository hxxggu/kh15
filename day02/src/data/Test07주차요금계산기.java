package data;

public class Test07주차요금계산기 {
	public static void main(String[] args) {
		// Q. 주차장 이용요금이 1시간 당 3,000원일 때, 다음 차량의 이용요금을 구하여 출력하시오 (단, 정각부터 59분까지는 요금이 같습니다)
		// 입차 시간 : 12시 40분, 출차 시간 : 16시15분
		
		//입력
		int h1 = 12, m1 = 40;
		int h2 = 16, m2 = 15;
		int period = 30; //단위기간
		int price = 3000; //단위요금
		
		//처리
		int t1 = h1*60+m1; //분으로 변환
		int t2 = h2*60+m2; //분으로 변환
		int t3 = t2-t1; //총 주차시간(분)
		
		int h3 = t3/60;
		int m3 = t3%60;
		
		int total = t3/period*price;
		//total = t3에 단위기간이 몇 번 포함되는지*price
		//total = price*h3 >오늘만 사는 코드(확장성 떨어지는 코드/세부조정 불가능)
		
		//출력
		System.out.println("주차시간 : "+h3+"시간"+m3+"분");
		System.out.println("주차요금은 "+total+"원입니다.");
	}
}
