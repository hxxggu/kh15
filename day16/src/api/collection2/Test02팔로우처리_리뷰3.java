package api.collection2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test02팔로우처리_리뷰3 {
	public static void main(String[] args){
		//코드에서 제일 중요한 것은 확실성과 그에 대한 신뢰 -> Set을 쓰는 이유
		
		//저장소 준비
		Set<String> followList = new HashSet<>();
		//List를 사용해도 가능은 하지만 set을 사용하는 것이 더 옳은 방법
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("아이디 입력 : ");
			String id = sc.next();
			if(id.equals("종료")) break;

			if(followList.add(id)) { //데이터가 들어갔다면(존재하지 않았던 아이디라면)
				System.out.println("["+id+"]님을 팔로우하였습니다");
			} else { //데이터가 들어가지 않았다면(존재하던 아이디라면)
				System.out.println("["+id+"]님을 팔로우 해제하였습니다");
				break;
			}
		}
		
		sc.close();
		System.out.println("총 팔로우한 인원은 ["+followList.size()+"]명 입니다");

		for(String id : followList) {
			System.out.println("아이디 = "+id);
		}
	}
}		

