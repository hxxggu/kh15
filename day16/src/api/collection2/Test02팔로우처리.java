package api.collection2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test02팔로우처리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int follower = 0;
		List<String> idList = new ArrayList<>();
		
		while(true) {
			System.out.print("아이디 입력 : ");
			String id = sc.next();
			
			if(id.equals("종료")) {
				System.out.println("총 팔로우한 인원 수는 "+follower+"명 입니다");
				break;
			} else if(idList.contains(id)) {
				System.out.println(id+"님을 팔로우 해제 하였습니다");
				idList.remove(id);
				follower--;
			} else if(!idList.contains(id)) {
				System.out.println(id+"님을 팔로우하였습니다");
				idList.add(id);
				follower++;
			}
		}
	}
}
