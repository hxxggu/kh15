package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test04사다리게임2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<String> userList = new ArrayList<>();
		List<String> actionList = new ArrayList<>();
		
		System.out.print("참가 인원 수를 입력하세요 : ");
		int num = sc.nextInt();
		
		System.out.println("참가자 이름을 입력하세요");
		for(int i=0; i<num; i++) {
			System.out.print("User "+(i+1)+":");
			String name = sc.next();
			userList.add(i, name);
		}
		System.out.println("결과 값을 입력하세요");
		for(int j=0; j<num; j++) {
			System.out.print("result "+(j+1)+":");
			String action = sc.next();
			actionList.add(j, action);
		}
		
		System.out.println("참여자 이름 : "+userList);
		System.out.println("결과 : "+actionList);
		
		System.out.println("====== 게임 시작 ======");
		
		Collections.shuffle(actionList);
		
		for(int i=0; i<num; i++) {
			System.out.println(userList.get(i)+" : "+actionList.get(i));			
		}

	}
}