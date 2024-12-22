package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test10포켓몬찾기1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> poketmon1 = List.of("1", "이상해씨", "풀");
		List<String> poketmon2 = List.of("25", "피카츄", "전기");
		List<String> poketmon3 = List.of("26", "라이츄", "전기");
		
		System.out.println("[ 포켓몬 검색 ]");
		System.out.print("▶ 몬스터 이름 : ");
		String name = sc.next();
		
		if(poketmon1.contains(name)) System.out.println("▶ 번호 : "+poketmon1.get(0)+", 이름 : "+poketmon1.get(1)+", 속성 : "+poketmon1.get(2));
		else if(poketmon2.contains(name)) System.out.println("▶ 번호 : "+poketmon2.get(0)+", 이름 : "+poketmon2.get(1)+", 속성 : "+poketmon2.get(2));
		else if(poketmon3.contains(name)) System.out.println("▶ 번호 : "+poketmon3.get(0)+", 이름 : "+poketmon3.get(1)+", 속성 : "+poketmon3.get(2));
		else System.out.println("몬스터가 존재하지 않습니다");
	}
}
