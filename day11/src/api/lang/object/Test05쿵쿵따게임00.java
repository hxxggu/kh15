package api.lang.object;

import java.util.Scanner;

public class Test05쿵쿵따게임00 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String given = "토요일";
		while(true) {
			System.out.println(given + "! 쿵쿵따! ");
			String input = sc.next();
			
			//유효한 입력인지 검사
			if(input.length() != 3) break;
			if(input.charAt(0) != given.charAt(given.length()-1)) break;
			
			given = input; //제시어 교체
		}
	}

}
