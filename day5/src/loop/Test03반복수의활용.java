package loop;

public class Test03반복수의활용 {
	public static void main(String[] args) {
		
		//화면에 1부터 10까지 출력하시오
		
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
		
		//화면에 1부터 10까지 홀수를 출력하시오
		// i : 1, 3, 5, 7, 9
		for(int i=1; i<=10; i+=2) {
			System.out.println(i);
		} System.out.println(); //빈줄 추가
		
		for(int i=1; i<=10; i+=2) {
			if(i%2 != 0) {
				System.out.println("홀수 : "+i);	
			}
		} System.out.println();
		
		//화면에 1부터 10까지 짝수를 출력하시오
		// i = 2, 4, 6, 8, 10
		for(int i=1; i<=10; i++) {
			if(i%2 == 0) {
				System.out.println("짝수 : "+i);
			}
		}
	}
}
