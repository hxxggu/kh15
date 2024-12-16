package api.lang.string;

import java.util.Scanner;

public class Test03로그인문제00 {

	public static void main(String[] args) {
		
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.next();
//		String id = "khacademy";
		System.out.print("비밀번호 : ");
		String password = sc.next();
//		String password = "123456";
		
//		boolean valid = 아이디 일치 && 비밀번호 일치;
//		boolean valid = id == "khacademy" && password == "123456";
		boolean valid = id.equalsIgnoreCase("khacademy") && password.equalsIgnoreCase("123456");
		if(valid) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}

	}

}
