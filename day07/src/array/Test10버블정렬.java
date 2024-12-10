package array;

public class Test10버블정렬 {
	
	public static void main(String[] args) {
		int[] num = new int[] {30, 50, 20, 10, 40};
		
		for(int j=2; j<num.length; j++) {
			int max = 0;
			for(int i=1; i<num.length; i++) { 
				if(num[max] < num[i]) { //num[0]보다 큰 num[i]가 나타날 경우, max의 값에 해당 i의 배열 순서를 삽입
					max = i;
				} else { //num[max]가 num[i]값보다 클 경우, 둘의 위치를 바꿈. num[max]를 뒤로 이동.
					int backup = num[max];
					num[max] = num[i];
					num[i] = backup;
				}
			}			
		}
		
		//출력
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
		}
		
	}
}
