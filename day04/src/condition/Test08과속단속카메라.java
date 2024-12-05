package condition;

import java.util.Scanner;

public class Test08과속단속카메라 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		int limitSpeed = 100; //제한속도 100km
		int baseFine = 40000; //기본 범칙금
		int maxFine = 100000; //범칙금 최대 10만원
		
		System.out.print("속력 : ");
		int speed = sc.nextInt(); //자동차 속력 입력
		
		int totalFine = speed-110;
		
		if(speed > (limitSpeed*10/100)) {
			System.out.println("범칙금이 없습니다.");
		} else if(totalFine<maxFine) {
			System.out.println("범칙금 : "+maxFine+"원");
		} else if() {
			
		} else {

		}
		
		System.out.println("속력 : "+speed+"km");
		System.out.println("범칙금 : "+totalFine+"원");
	}
}
