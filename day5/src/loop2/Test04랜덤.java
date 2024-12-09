package loop2;

import java.util.Random;

public class Test04랜덤 {

	public static void main(String[] args) {
		//랜덤(Random)
		//: 도저히 뭐가 나올지 알 수 없는 값
		//: 로또, 주사위, 동전...
		//: 어느 범위에서 나오는지는 알 수 있다
		//: 프로그램에서 생성하는건 100% 랜덤은 아니다 (의사랜덤)
		
		Random r = new Random();
		
		//System.out.println(r.nextInt()); //int 전체
		
		int dice = r.nextInt(6)+1; //주사위(1부터 6개)
		System.out.println("dice : "+dice);
		
		int lotto = r.nextInt(45)+1; //로또(1부터 45개)
		System.out.println("lotto : "+lotto);
		
		int otp = r.nextInt(900000)+100000; //otp(100000부터 999999까지/6자리 정수)
		System.out.println("otp : "+otp);
	}
}