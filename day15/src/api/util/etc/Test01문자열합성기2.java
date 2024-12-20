package api.util.etc;

import java.util.Scanner;
import java.util.StringJoiner;

public class Test01문자열합성기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringJoiner joiner = new StringJoiner(", ", "[", "]");
		int cnt = 0;
		
		while(true) {
			System.out.print("입력 : ");
			String word = sc.next();
			if(word.equals("종료"))break;
			
			cnt++;
			joiner.add(word);
		}
		sc.close();
		System.out.println("입력한 단어 목록");
		System.out.println(joiner.toString());
		System.out.println("총 "+cnt+"번 입력했습니다");
		
	}
}