package api.lang.string;

import java.util.Scanner;

public class Test09닉네임검사 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("닉네임을 입력하세요 : ");
		
		String name = "엘사";
		
		if(2<=name.length() && name.length()<=10) { //글자 수 제한
			for(int i=0; i<name.length(); i++) {
				char check = name.charAt(i);
				boolean kor = check>='가' && check<='힣';
				//닉네임의 구성요소가 한글일 때 = true
				boolean num = check>='' && check<='';
				//닉네임의 구성요소가 숫자일 때
				if(kor==true && num==true) {
					if(name.contains("운영자") != true) {
						char first = name.charAt(0);
						boolean number = 
						if() {
							
							System.out.println("닉네임 설정 완료");
							break;
						}
					}
				}
			}
		System.out.println("닉네임 형식에 맞지 않습니다");
		}
	}
}