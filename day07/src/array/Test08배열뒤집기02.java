package array;

public class Test08배열뒤집기02 {
	public static void main(String[] args) {
		
		//입력
		int[] num = new int[] {30, 50, 20, 10, 40};
		
		//처리
		//2. 확장성 있는 코드
		// : length/2회만큼 데이터 교체를 하면 배열이 뒤집힌다
		for(int i=0; i<num.length/2; i++) {
			//System.out.println("["+i+"] vs ["+(num.length-1)+"]");
			//num[i]와 num[num.length-1-i]를 바꿔야 한다
			int backup = num[i];
			num[i] = num[num.length-1-i];
			num[num.length-1-i] = backup;
		}
		
		//출력
		for(int i=0; i<num.length; i++) {
			System.out.print(num[i]+"\t");
		}
	}
}