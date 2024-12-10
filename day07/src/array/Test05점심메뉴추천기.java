package array;

import java.util.Random;
import java.util.Scanner;

public class Test05점심메뉴추천기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		
		System.out.print("메뉴의 수를 정하시오 : ");
		int num = sc.nextInt();
		String[] food = new String[num];
		for(int i = 0; i<food.length; i++) {
			System.out.print("메뉴 입력 : ");
			food[i] = sc.next();
		}
		
		int menu = r.nextInt(food.length);
		System.out.println("추천 메뉴는 "+food[menu]+"입니다");
	}

}
