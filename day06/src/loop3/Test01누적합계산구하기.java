package loop3;

public class Test01누적합계산구하기 {
	public static void main(String[] args) {
		//Ex. 1부터 10까지 더하시오.
		
		//int total = 1+2+3+4+5+6+7+8+9+10;
		//System.out.println("total : "+total);
		
		int total  = 0;
		for(int i=1; i<=10; i++) {
			total += i;			
		}
		System.out.println("total : "+total);
	}
}