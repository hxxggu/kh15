package api.collection4;

import java.util.Stack;

public class Test01LIFO저장소 {
	public static void main(String[] args) {
		//LIFO (Last In First Out)
		//: 늦게 들어온 것이 먼저 나감 (최신순으로 관리)
		//: 막다른 골목에 주차를 하는 상황과 유사, 기둥에 고리를 거는 상황
		//: 대표적으로 Stack이 존재
		//: vector를 상속받음 > vector의 사용을 권장하지 않으므로 stack의 사용도 권장하지 않는 편.
		
		Stack<String> stack = new Stack<>();
		
		//추가 : add()가 아니라 push()
		stack.push("구글"); //추가
		stack.push("네이버"); //추가
		stack.push("카카오"); //추가
		
		System.out.println("최신데이터 = "+stack.peek()); //최신데이터가 무엇인지 묻는 명령어
		stack.pop(); //삭제(뒤로 가기 or 컨트롤+z)
		System.out.println("최신데이터 = "+stack.peek());
		stack.pop(); //삭제(뒤로 가기 or 컨트롤+z)
		System.out.println("최신데이터 = "+stack.peek());
	}
}
