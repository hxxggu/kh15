package condtion;

import java.util.Scanner;

public class Test08과속단속카메라2 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		System.out.print("자동차 속도 : ");
		int speed = sc.nextInt();
		
		int limit = 100;
		int base = 40000, plus = 10000, max = 100000;
		int per = 10;
		int over = limit+limit*per/100;
		
		if(speed>=over) {
			int gap = speed-over;
			int fine = base+gap/10*plus;
			System.out.println("초과한 속도 : "+gap+"km");
			if(fine<max) {
			System.out.println("범칙금 : "+fine+"원");
			} else {
			System.out.println("범칙금 : "+max+"원");
			}
		}
		else { 
			System.out.println("정상 통과");
		}
	}
}
