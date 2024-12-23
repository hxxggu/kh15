package api.collection3;

import java.util.HashMap;
import java.util.Map;

public class Test01KeyValue저장소 {

	public static void main(String[] args) {
		//Map
		//: key-value 저장소
		//: 개별적인 데이터에 가장 빠르게 접근하기 위한 형태
		//: key는 중복이 있으면 안됨. value는 같아도 됨. (ex. id가 key, pw가 value)
		//: key는 유일해야 하며 드러나는 정보
		//: value는 중복이 가능하며 숨겨저 있는 정보
		//: key를 이용해서 value를 빠르게 접근하는 것이 목표
		
		Map<String, String> monsters = new HashMap<>();
		
		//데이터 추가
		monsters.put("피카츄", "전기"); //두 정보는 하나의 데이터로 침
		monsters.put("이상해씨", "풀");
		monsters.put("라이츄", "전기");
		monsters.put("파이리", "불꽃");
		
		monsters.put("이상해씨", "독"); //key가 같을 경우 value를 덮어쓰기
		
		//데이터 개수
		System.out.println("데이터 개수 : " + monsters.size());
		
		//데이터 검색
		System.out.print("피카츄가 key에 있습니까? ");
		System.out.println(monsters.containsKey("피카츄"));
		System.out.print("물속성이 있습니까? ");
		System.out.println(monsters.containsValue("물"));

		//데이터 삭제
		monsters.remove("라이츄"); //key가 라이츄인 데이터를 지우세요
		
		//데이터 추출 (key를 이용해서 value를 불러오는 것)
		System.out.println("피카츄 속성? "+monsters.get("피카츄"));
		System.out.println("꼬부기 속성? "+monsters.get("꼬부기")); //null 출력
		
		//load factor(0.75): 얼만큼 데이터가 차면 데이터의 공간을 만들 것인가 > 0.75 (75%)
		
		System.out.println(monsters);
	}

}
