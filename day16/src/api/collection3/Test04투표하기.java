package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test04투표하기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> voteResult = new HashMap<>();
		
		int cnt = 0;
		
		while(true) {
			System.out.print("이름 입력 : ");
			String name = sc.nextLine();
			
			if(name.equals("종료")) {
				System.out.println("투표를 종료합니다");
				break;
			}
			
			if(voteResult.containsKey(name)) {
				voteResult.put(name, voteResult.get(name)+1);
				System.out.println("["+ name + "] 현재 "+voteResult.get(name)+"표 획득!");
			} else {
				voteResult.put(name, 1);
				System.out.println("["+ name + "] 현재 "+voteResult.get(name)+"표 획득!");
			}
		}
		
		System.out.println("< 투표 결과 >");
		Set<String> names = voteResult.keySet();
		for(String name : names) {
			System.out.println(name+" : "+voteResult.get(name)+"표");
		}
		
		
		
		
		
		
		
	}
}