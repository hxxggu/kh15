package loop;

public class Test05_369게임01 {
	public static void main(String[] args) {
		
		System.out.println("게임 시작!");
		
		for(int i=1; i<=99; i++) {
			int ten = i/10, one = i%10;
			
			boolean checkTen = ten==3 || ten==6 || ten==9;
			boolean checkOne = one==3 || one==6 || one==9;
			
			if(checkTen && checkOne) { //둘다 3,6,9인 경우
				System.out.println("짝짝");
			} else if(checkTen || checkOne) { //둘중 하나만 3,6,9인 경우
				System.out.println("짝");
			} else {
				System.out.println(i);
			}
		}
	}
}
