package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test04사다리게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<String> userList = new ArrayList<>(); 
		userList.add("토끼"); 
		userList.add("호랑이");
		userList.add("조랑말");
		
		List<String> action = new ArrayList<>();
		action.add("꽝");
		action.add("꽝");
		action.add("당첨");
		
		System.out.println(userList);
		System.out.println(action);
		for(int i=0; i<20; i++) System.out.print("=");
		System.out.println("결과 확인");
		
		Collections.shuffle(userList);
		Collections.shuffle(action);
		
		for(int i=0; i<userList.size(); i++) {
			System.out.println(userList.get(i)+" : "+action.get(i));			
		}

	}
}