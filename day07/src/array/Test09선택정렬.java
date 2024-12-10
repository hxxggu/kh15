package array;

public class Test09선택정렬 {
	public static void main(String[] args) {
		//배열 준비
		int[] num = new int[] {10, 50, 20, 30, 40};
		//처리
		for(int k=0; k<num.length-1; k++) {
			// k부터 마지막 지점 사이의 최소값(min)을 k지점과 교체
			// k의 값은 (배열의 수-1), 배열의 마지막은 비교할 필요가 없으므로
			int min = k;
			for(int i=k+1; i<num.length; i++) {
				if(num[min] > num[i]) {
					min = i;
				}
			}
			int backup = num[k];
			num[k] = num[min];
			num[min] = backup;
		}
		//출력
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
		}
	}
}