package loop3;

public class Test03현명한노인01 {
	public static void main(String[] args) {
		
		int gold = 1;
		int total = 0;
		for(int day=1; day<=30; day++) {
			System.out.println(day+"일차 : 금화 "+gold+"개");
			total += gold; 
			
			gold *= 2;
		}
		System.out.println("총 받는 금화 : "+total+"개");
	}
}
