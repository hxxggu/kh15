package task;

import java.util.Scanner;

public class 과속단속카메라 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		int limitSpeed = 100; //제한속도 100km
		int baseFine = 40000; //기본 범칙금
		int maxFine = 100000; //최대 범칙금
		
		System.out.print("속도 : ");
		int speed = sc.nextInt(); //자동차 속도 입력
		
		int maxSpeed = limitSpeed*110/100; //벌금을 내지 않는 최대 속도(110km)
		int overSpeed = speed-maxSpeed; //초과 속도
		int plusFine = overSpeed/10*10000;  //추가 범칙금
		int totalFine = baseFine+plusFine; //총 범칙금
		
		if(speed <= maxSpeed) { //속도가 최대속도보다 빠를 때
			System.out.println("범칙금이 없습니다.");
		} else if(totalFine >= maxFine) { //총 범칙금이 최대 범칙금 이상일 때
			System.out.println("기준치 초과 속도 : "+overSpeed+"km");
			System.out.println("기본 범칙금("+baseFine+"원)을 포함한 총 범칙금 : "+maxFine+"원");
		} else {
			System.out.println("기준치 초과 속도 : "+overSpeed+"km");
			System.out.println("기본 범칙금("+baseFine+"원)을 포함한 총 범칙금 : "+totalFine+"원");
		}
	}
}