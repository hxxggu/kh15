package array;

public class Test08배열뒤집기03 {
	public static void main(String[] args) {
		
		//입력
		int[] num = new int[] {30, 50, 20, 10, 40};
		
		//처리
		//2. 확장성 있는 코드
		// : length/2회만큼 데이터 교체를 하면 배열이 뒤집힌다
		int left = 0, right = num.length-1;
		for(int i=0; i<num.length/2; i++) {
			//System.out.println("["+left+"] vs ["+right+"]");
			//num[left]와 num[right]를 바꿔야 한다
			int backup = num[left];
			num[left] = num[right];
			num[right] = backup;
			
			left++;
			right--;
		}
		
		//출력
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
		}
	}
}