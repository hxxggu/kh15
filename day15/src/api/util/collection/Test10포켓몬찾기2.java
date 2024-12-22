package api.util.collection;

import java.util.Scanner;

public class Test10포켓몬찾기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PoketList poketlist = new PoketList();
		
		poketlist.add(new Poketmon(1, "이상해씨", "풀"));
		poketlist.add(new Poketmon(25, "피카츄", "전기"));
		poketlist.add(new Poketmon(26, "라이츄", "전기"));
		
		System.out.print("포켓몬 이름을 입력하세요 : ");
		String search = sc.nextLine();
		poketlist.search(search);
		sc.close();
	}
}
