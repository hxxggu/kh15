package oop.poly1;

public class Test01다형성 {
	public static void main(String[] args) {
		
		//업캐스팅(up-casting)이란 데이터의 보관형태를 상위형태로 보관하는 것
		//다운캐스팅(down-casting)이란 데이터의 보관형태를 원래 형태로 되돌리는 것
		
		//업캐스팅의 예시
		Galaxy p1 = new Galaxy();
		
		Phone p2 = p1; //업캐스팅: 보관 형태가 Galaxy에서 Phone으로 바뀜
		
		//다운캐스팅의 예시
//		Galaxy p3 = p2;
		Galaxy p3 = (Galaxy)p2; //다운캐스팅 : 보관 형태가 Phone에서 Galaxy로 되돌려짐
		
	}
}
