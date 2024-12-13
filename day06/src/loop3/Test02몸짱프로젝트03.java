package loop3;

public class Test02몸짱프로젝트03 {
	public static void main(String[] args) {
		
		int total = 0;
		int pushup = 1;
		for(int day=1; day<=30; day++) {
			System.out.println(day+"일차 : "+pushup+"개");
			total += pushup;
			
			//다음날을 위한 처리
			pushup += 3;
		}
		System.out.println("누적 합계 : "+total+"개");
	}
}
