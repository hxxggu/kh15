package data3;

public class Test01논리 {
	public static void main(String[] args) {
		//논리 데이터 (logical data)
		//: 예/아니오 와 같은 단답형으로 표현할 수 있는 데이터
		//: 형태는 boolean 단 한 개만 존재
		//: 숫자를 비교해서 논리데이터를 만들어내야 함
		//: 비교연산 : >=(이상), <=(이하), >(초과), <(미만), ==(같다), !=(다르다)
		
		
		//boolean a=false;
		int money = 25000;
		int pizza = 22000;
		//boolean order = money가 pizza 이상인가요?
		boolean order = money >= pizza;
		System.out.println(order);
		
	}
}
