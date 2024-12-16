package api.lang.string;

import java.util.Scanner;

public class Test09닉네임검사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("닉네임을 입력하세요 : ");
		String name = sc.next();
		
		int pass = 0;
		
		if(2<=name.length() && name.length()<=10) pass++;
		
		for(int i=0; i<name.length(); i++) {
			char check = name.charAt(i);
			if(('가'>check && check>'힣') || ('0'>check && check>'9')) break;
		} pass++;
		
		if(name.contains("운영자") != true) pass++;
		
		char first = name.charAt(0);
		boolean num ='0'<=first && first<='9';
		if(num == false) pass++;
		
		if(pass == 4) {
			System.out.println("닉네임 설정 완료");
		} else {
			System.out.println("닉네임 형식에 맞지 않습니다");
		}
	}
}