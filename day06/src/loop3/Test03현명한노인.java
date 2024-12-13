package loop3;

public class Test03현명한노인 {
	public static void main(String[] args) {
		int gold = 1, total = 0;
		for(int day=1; day<=30; day++) {
			System.out.println(day+"일차 금화 개수 : "+gold+"개");
			total = total+gold;
			gold = gold*2;
		}
		System.out.println("총 금화의 개수 : "+gold+"개");
	}
}
