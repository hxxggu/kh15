package api.collection2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test02팔로우처리_리뷰2 {
	public static void main(String[] args){
		
		//저장소 준비
		Set<String> followList = new TreeSet<>(); //TreeSet을 사용할 수도 있지만, 속도가 느려짐 (아직은 인지할 수 없지만, 대용량 데이터를 삽입하면 느려짐)

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("아이디 입력 : ");
			String id = sc.next();
			if(id.equals("종료")) break;
			
			//(*참고)
			//: Set은 contains()를 쓰지 않아도 존재 여부를 알 수 있다
			//: add 메서드를 실행했을 때 반환 값이 논리가 나옴
			if(followList.add(id)) { //데이터가 들어갔다면(존재하지 않았던 아이디라면)
				System.out.println("["+id+"]님을 팔로우하였습니다");
			} else { //데이터가 들어가지 않았다면(존재하던 아이디라면)
				System.out.println("["+id+"]님을 팔로우 해제하였습니다");
				break;
			}
		}
		sc.close();
		System.out.println("총 팔로우한 인원은 ["+followList.size()+"]명 입니다");
		
//		for(int i=0; i<followList.size(); i++) {
//			System.out.println(followList.get(i)); //get 메서드가 없음
//		}
		
		for(String id : followList) {
			System.out.println("아이디 = "+id);
		}
	}
}		

