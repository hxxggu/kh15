package loop;

public class Test05_369게임 {
	public static void main(String[] args) {
		
		System.out.println("게임 시작!");
		
		for(int i=1; i<100; i++) {
			if((i/10==3 && i%10 ==3)||(i/10==6 && i%10==6)||(i/10==9 && i%10==9)) {
				System.out.println("짝짝");
			} else if(i/10==3 || i/10==6 || i/10==9) {
				System.out.println("짝");
			} else if(i%10==3 || i%10==6 || i%10==9) {
				System.out.println("짝");
			} else {
				System.out.println(i);
			}
		}
		
		int n = 13;
		System.out.println(n/10%3 == 0); //십의 자리가 3인 경우 출력하라
		System.out.println(n%10%3 == 0); //일의 자리가 3인 경우 출력하라
		
		
		for(int i=1; i<100; i++) {
//			if((i%10==i/10)&&(i%3==0)) {
			if((i/10%3==0) && (i%10%3==0)) {
				System.out.println("짝짝");
			} else if(i/10==3 || i/10==6 || i/10==9) {
				System.out.println("짝");
			} else if(i%10==3 || i%10==6 || i%10==9) {
				System.out.println("짝");
			} else {
				System.out.println(i);
			}
		}	
	}

}
