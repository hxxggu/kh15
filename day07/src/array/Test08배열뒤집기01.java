package array;

public class Test08배열뒤집기01 {
	public static void main(String[] args) {
		
		//입력
		int[] num = new int[] {30, 50, 20, 10, 40};
		
		//처리
		//1. 오늘만 사는 코드
		int backup = num[0];
		num[0] = num[4];
		num[4] = backup; 
		//0번 배열과 4번 배열의 위치를 교체
		backup = num[1];
		num[1] = num[3];
		num[3] = backup;
		//1번 배열과 3번 배열의 위치를 교체
		
		//출력
		for(int i=0; i<num.length;i++) {
			System.out.println(num[i]);
		}
	}
}