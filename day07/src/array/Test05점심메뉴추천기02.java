package array;

import java.util.Random;
import java.util.Scanner;

public class Test05점심메뉴추천기02 {

	public static void main(String[] args) {
		
		//5칸의 배열에 사용자가 입력하는 메뉴 넣기
		Scanner sc = new Scanner(System.in);
		
		String[] menuList = new String[5];
		
		//입력
		for(int i=0; i<menuList.length; i++) {
			System.out.print("메뉴 입력 : ");
			menuList[i] = sc.next();
		}
		
		//출력
		Random r = new Random();
		//int position = r.nextInt(5); //0부터 5개(0~4)
		int position = r.nextInt(menuList.length);
		System.out.println(menuList[position]);
	}
}
