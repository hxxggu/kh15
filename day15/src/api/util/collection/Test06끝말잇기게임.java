package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test06끝말잇기게임 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<String> history = new ArrayList<>();
		history.add("자바");
		
		while(true) {
			String given = history.get(history.size()-1); //history.getLast() -JDK 21부터 사용가능
			System.out.print("제시어 : "+given+" → ");
			String input = sc.nextLine();
			
			//1.입력값 형식 검사
			if(input.matches("^[가-힣]{2,6}$") == false) break;
			
			//2.연결 검사
			if(given.charAt(given.length()-1) != input.charAt(0)) break;
			if(given.endsWith(input.substring(0, 1)) == false) break;
			if(input.substring(given.length()-1).startsWith(input) == false) break;
			
			//3.저장소 중복 검사
			if(history.contains(input)) break;
			
			history.add(input);
		}
		sc.close();
		
		System.out.println("게임 오버");
		System.out.println("< 입력한 기록 >");
//		for(int i=0; i<history.size(); i++) System.out.println(" → "+history.get(i)); //하단과 같은 의미
		
		for(String word:history) { //확장 Foreach
			System.out.println(" → "+word);
		} //일부분 반복X, 전체 출력할 때만 가능
	}
}