package array;

import java.util.Scanner;

public class Test05점심메뉴추천기01 {

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
		for(int i=0; i<menuList.length; i++) {
			System.out.println(menuList[i]);
		}
	}
}
