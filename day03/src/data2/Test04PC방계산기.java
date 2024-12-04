package data2;

public class Test04PC방계산기 {
	public static void main(String[] args) {
		//Q. PC방 요금이 한시간이 1000원. 12시20분에 들어와서 15시30분까지 이용한 손님의 계산금액은?
		//요금은 1분당으로 계산. 100원 미만의 금액은 받지 않음.
		
		int priceHour = 1000;
		float priceMin = priceHour/60f;
		
		int outHour = 15;
		int outMin = 30;
		int inHour = 12;
		int inMin = 20;
		
		int outTime = (outHour*60)+outMin;
		int inTime = (inHour*60)+inMin;
		
		int useTime = outTime-inTime;
		System.out.println("사용 시간 : "+useTime+"분");
		
		int totalPrice = (int)(useTime*priceMin)/100*100;
		System.out.println("계산 금액 : "+totalPrice+"원");	
	}
}
