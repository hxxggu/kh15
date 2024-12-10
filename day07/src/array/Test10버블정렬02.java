package array;

public class Test10버블정렬02 {
	public static void main(String[] args) {
		
		
		//입력
		int[] num = new int[] {30, 20, 10, 40, 50};
		
		//처리
		//: 버블 정렬 1회차 : [0]vs[1], [1]vs[2], [2]vs[3]
		//: 큰 데이터가 뒤에 있도록 교체하며 진행
		for(int i=0; i<=2; i++) {
			//System.out.println("["+i+"] vs ["+(i+1)+"]");
			if(num[i] > num[i+1]) { //큰 데이터가 앞에 있다면
				int backup = num[i]; //교체
				num[i] = num[i+1];
				num[i+1] = backup;
			}
		}
		
		//출력
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
		}
	}
}
