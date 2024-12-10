package array;

public class Test10버블정렬03 {
	public static void main(String[] args) {
		int[] num = new int[] {30, 20, 10, 40, 50};
		for(int j=num.length-2; j>=0; j--) {
			for(int i=0; i<j; i++) {
				if(num[i] > num[i+1]) {
					int backup = num[i];
					num[i] = num[i+1];
					num[i+1] = backup;
				}
			}			
		}
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
		}
	}
}