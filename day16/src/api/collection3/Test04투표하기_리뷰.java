package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test04투표하기_리뷰 {
	public static void main(String[] args) {
		
		Map<String, Integer> people = new HashMap<>();

		//사용자 입력
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			if(name.equals("종료")) break;
			
			if(people.containsKey(name)) { //이미 존재하는 이름이면
				int cnt = people.get(name); //원래 득표수를 구해서
				cnt++;
				people.put(name, cnt); //카운트를 1 증가시켜서 덮어쓰기
				System.out.println("["+name+"]님의 득표수 : "+cnt);
			} else { //처음 입력한 이름이면
				people.put(name, 1);
				System.out.println("["+name+"]님의 득표수 : 1");
			}
		}
		sc.close();
		System.out.println("< 투표 결과 >");
//		Set<String> names = people.keySet();
		for(String name : people.keySet()) {
			System.out.println("["+name+"] - "+people.get(name)+"표");
		}
	}
}