package loop;

public class Test04숫자찾기2 {
	public static void main(String[] args) {
		
		//범위와 조건을 이용하여 풀이
		for(int i=1; i<100; i++) {
			int ten=i/10, one=i%10;
			boolean checkTen = ten==5;
			boolean checkOne = one==5;
			boolean hasFive = checkTen || checkOne;
			//if(i/10==5 || i%10==5) {
			if(hasFive) {
				System.out.println("i : "+i);
			}
		}
	}
}