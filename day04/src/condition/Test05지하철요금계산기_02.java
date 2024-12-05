package condition;
import java.util.Scanner;

public class Test05지하철요금계산기_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int adult = 1400, teen = 800, child = 500, senior = 0, baby = 0;
		int deposit = 500;
		
		System.out.print("출생년도를 입력하시오 : ");
		int birth = sc.nextInt();
		
		int yearCur = 2024;
		int age = yearCur-birth+1;
		int totalPrice=0;
		
		if (20<=age && age<=64) {
			System.out.println("성인입니다.");
			totalPrice=adult+deposit;
		} else if (14<=age && age<=19) {
			System.out.println("청소년입니다.");
			totalPrice=teen+deposit;
		} else if (8<=age && age<=13) {
			System.out.println("어린이입니다.");
			totalPrice=child+deposit;
		} else {
			System.out.println("영유아 및 어르신은 이용요금이 무료입니다.");
			totalPrice=senior+deposit;
		}
		System.out.println("요금은 "+totalPrice+"원입니다.(카드보증금 "+deposit+"원 포함)");
	}
}