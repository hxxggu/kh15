package api.util.collection;

import java.util.ArrayList;
import java.util.List;

public class Test01컬렉션프레임워크 {
	public static void main(String[] args) {
		//JCF(Java Collection Framework)
		//: 자바에서 제공하는 대용량 가변 저장소 (cf. 배열)
		//: 데이터의 저장 원리에 따라 여러 종류를 구분
		//ex. 리스트, 세트, 스택, 큐, 데크...
		//: 다른 말로 자료구조(Data Structure) 구현체라고 부름
		
		//List(리스트)
		//: 순서를 보장하는 저장소
		//: ArrayList는 배열의 형태를 가진 리스트
		ArrayList a = new ArrayList(); //raw type : 원시적인 형태임을 나타내는 주의사항 / 내용물이 없어서 경고
		ArrayList<String> b = new ArrayList<String>(); //문자열이 담긴 저장소
		ArrayList<String> c = new ArrayList<>(); //문자열이 담긴 저장소
//		ArrayList<int> b = new ArrayList<>(); //원시형은 제네릭 타입으로 사용불가
		ArrayList<Integer> d = new ArrayList<>(); //정수가 담긴 저장소
		List<String> e = new ArrayList<>(); //업캐스팅(최종 형태)
		
		//데이터 추가
		e.add("피카츄"); //0
		e.add("라이츄"); //1
		e.add("파이리"); //2 → 3
		e.add("꼬부기"); //3 → 4
		e.add("버터플"); //4 → 5
		
		e.add(2, "또가스"); //2번에 삽입
		//저장소에 데이터를 추가할 때는 add
		
//		d.add("피카츄"); //d에는 정수만 넣을 수 있어서 오류
		System.out.println(e);
		System.out.println(e.size()); //데이터 개수
		
		//데이터 탐색
		System.out.print("피카츄 있어요? ");
		System.out.println(e.contains("피카츄")); //true 출력
		System.out.print("푸린 있어요? ");
		System.out.println(e.contains("푸린")); //false 출력
		//contains : 저장소 안의 유무 확인
		
		//데이터 삭제
		e.remove("파이리"); //파이리와 일치하는 데이터를 지우세요
		System.out.println(e); //데이터값 "파이리" 삭제
		e.remove(1); //1 위치의 데이터를 지우세요
		System.out.println(e); //1번 위치의 데이터값 "라이츄" 삭제
		
		
		
	}
}