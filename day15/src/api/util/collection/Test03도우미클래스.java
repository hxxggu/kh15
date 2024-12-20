package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test03도우미클래스 {

	public static void main(String[] args) {
		//: 이름 뒤에 s로 끝나는 것이 특징
		//ex. Objects 클래스는 Object의 도우미
		//ex. Arrays 클래스는 배열(Array)의 도우미
		//ex. Collection 클래스는 Collection의 도우미
		
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<=10; i++) {
			list.add(i);
		} System.out.println(list+"\n");
		
		//Q. list의 순서를 뒤집어보세요
		Collections.reverse(list);
		System.out.println(list+"\n");
		
		//Q. list의 순서를 섞어보세요
		Collections.shuffle(list);
		System.out.println(list+"\n");
		
		//Q. list를 정렬해보세요
		Collections.sort(list);
		System.out.println(list+"\n");
		
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list+"\n");
		
		//특정 위치에 있는 데이터를 추출
		System.out.println("3번 위치 = "+list.get(3));
	}
}
