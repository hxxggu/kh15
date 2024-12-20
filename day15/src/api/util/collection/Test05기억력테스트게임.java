package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test05기억력테스트게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>(); 
		int cnt = 0;
		
		while(true) {
			System.out.print("편의점에 가면 : ");
			String input = sc.next();
		
			if(list.contains(input)) {
				System.out.println("게임 오버!");
				break;
			} else {
				list.add(input);
				cnt++;
			}
		}
		
		System.out.println("총 입력 개수 : "+cnt);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(">> "+list.get(i));			
		}
	}
}