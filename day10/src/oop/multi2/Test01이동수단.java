package oop.multi2;

import java.util.Scanner;

public class Test01이동수단 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[ 기능을 알고싶은 이동수단의 번호를 입력하세요 ]");
		System.out.print("1.드론\n2.버스\n3.비행기\n4.기차\n5.전동킥보드\n: ");
		
		while(true) {
			int input = sc.nextInt();
			if(input == 1) {
				Drone d = new Drone();
				d.move();
				d.fly();
				d.on();
				d.off();
				break;
			} else if(input == 2) {
				Bus b = new Bus();
				b.move();
				break;
			} else if(input == 3) {
				Airplane a = new Airplane();
				a.move();
				a.fly();
				a.reservation();
				break;
			} else if(input == 4) {
				Train t = new Train();				
				t.move();
				t.reservation();
				break;
			} else if(input == 5) {
				Kickboard k = new Kickboard();
				k.move();
				k.on();
				k.off();
				break;
			} else {
				System.out.println("번호를 잘못 입력하셨습니다");
			}
		};
	}
}
