package regex;

import java.util.Scanner;

public class Test02아이디검사 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("아이디 입력 : ");
//		String id = sc.next();
		
		String id = "testuser1";
		
		String regex = "^[a-z][a-z0-9\\-_]{4,19}$";
		
		if(id.matches(regex)) {
			System.out.println("올바른 아이디 형식입니다");
		} else {
			System.out.println("아이디는 영문소문자로 시작하고 숫자를 포함해 5~20자로 작성해야 합니다");
		}
	}
}