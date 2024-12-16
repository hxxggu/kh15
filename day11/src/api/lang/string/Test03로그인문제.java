package api.lang.string;

import java.util.Scanner;

public class Test03로그인문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ID : ");
		String inputId = sc.next();
		System.out.print("Password : ");
		String inputPw = sc.next();
		
		String baseId = new String("khacademy");
		String basePw = new String("123456");
		
		if(inputId.equalsIgnoreCase(baseId) && inputPw.equalsIgnoreCase(basePw)) {
			System.out.println("로그인 성공");
		} else System.out.println("로그인 실패");
	}
}