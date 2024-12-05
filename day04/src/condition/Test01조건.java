package condition;

public class Test01조건 {
	public static void main(String[] args) {
		//조건
		//: 상황에 따라 실행이 될 수도 있는 구문
		//: if(조건식) {코드}
		
		int num = 4;
		
		if(num%2==1) { //조건식
			System.out.println("홀수"); //코드
		} else {
			System.out.println("짝수");
		}
	}
}
