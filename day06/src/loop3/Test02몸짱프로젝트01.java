package loop3;

public class Test02몸짱프로젝트01 {
	public static void main(String[] args) {
		
		//int total  = 1 + 4 + 7 + 10 + 13 + ... + 88;
		
		int total = 0;
		for(int i=1; i<=88; i+=3) {
			total += i;
			System.out.println("오늘 한 푸시업 : "+i);
			System.out.println("누적 합계 : "+total);
		}
		System.out.println("total : "+total);
	}
}
