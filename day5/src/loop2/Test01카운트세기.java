package loop2;

public class Test01카운트세기 {
	public static void main(String[] args) {
		
		//ex. 1부터 100 사이의 짝수 개수 구하기
		
		int cnt = 0; //cnt를 세기 위한 변수를 0으로 준비

		for(int i=1; i<=100; i++) {
			if(i%2==0) {
				cnt++;
			}
		}
		System.out.println("짝수의 개수 : "+cnt);
	}
}
