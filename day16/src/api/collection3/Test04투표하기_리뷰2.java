package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test04투표하기_리뷰2 {
	public static void main(String[] args) {
		
		Map<String, Integer> people = new HashMap<>();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			if(name.equals("종료")) break;
			
			Integer cnt = people.get(name); //해당 이름의 득표수를 추출
//		if(cnt == null) cnt = 1;
//		else cnt++;
			if(cnt == null) cnt = 0;
			cnt++;
			people.put(name, cnt); //카운트를 1 증가시켜서 덮어쓰기
			System.out.println("["+name+"]님의 득표수 : "+cnt);
		}
		sc.close();
		System.out.println("< 투표 결과 >");
//		Set<String> names = people.keySet();
		for(String name : people.keySet()) {
			System.out.println("["+name+"] - "+people.get(name)+"표");
		}
	}
}