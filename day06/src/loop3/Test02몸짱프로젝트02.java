package loop3;

public class Test02몸짱프로젝트02 {
	public static void main(String[] args) {
		
		int total = 0;
		for(int day=1; day<=30; day++) {
			int pushup = day*3-2;
			System.out.println(day+"일차 : "+pushup+"개");
			total += pushup;
		}
		System.out.println("누적 합계 : "+total+"개");
	}
}
