package loop3;

public class Test03현명한노인01 {
	public static void main(String[] args) {
		
		long gold = 1L;
		long total = 0L;
		for(int day=1; day<=40; day++) {
			//day를 40으로 바꾼다면, 변수의 형태가 int 일 때는 오류 발생
			//결과값이 int의 한계를 넘기 때문에. long으로 변경 시 정상적으로 실행됨
			System.out.println(day+"일차 : 금화 "+gold+"개");
			total += gold; 
			
			gold *= 2;
		}
		System.out.println("총 받는 금화 : "+total+"개");
	}
}
