package api.lang.string;

import java.util.Scanner;

public class Test05쿵쿵따게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[ 쿵쿵따 시작 ]");
		String first = "토요일";
		System.out.print(first+"! 쿵쿵따! ");
		String input1 = sc.next();
		if(first.charAt(first.length()-1) == input1.charAt(0)) {
			System.out.print(input1+"! 쿵쿵따! ");
		} else {
			System.out.println("Game Over");
		}
		
		while(true) {
			String input2 = sc.next();
			if(input2.length() == 3) {
				if(input1.charAt(input1.length()-1) == (input2.charAt(0))) {
					System.out.print(input2+"! 쿵쿵따! ");
					input2 = input1;
				} else break;
			} else break;
		}
		System.out.println("Game Over");
	}
}
