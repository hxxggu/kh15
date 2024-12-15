package oop.multi2;

import java.util.Scanner;

public class Test01이동수단 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("[ 기능을 출력할 이동수단의 번호를 입력하세요 ]");
		System.out.print("1.드론  2.버스  3.비행기  4.기차  5.전동킥보드\n : ");
		
		int num = sc.nextInt();
		Transportation trans;
		Airplane a = new Airplane(num);
		Bus b = new Bus(num);
		Drone d = new Drone(num);
		Kickboard k = new Kickboard(num);
		Train t = new Train(num);
	}
}
