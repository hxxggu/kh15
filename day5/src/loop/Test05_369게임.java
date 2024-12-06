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
		
		for(int i=1; i<100; i++) {
			if((i%10==i/10)&&(i%3==0)) {
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
