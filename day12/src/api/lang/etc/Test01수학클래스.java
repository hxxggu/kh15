package api.lang.etc;

public class Test01수학클래스 {

	public static void main(String[] args) {
		//특이한 형태의 클래스들
		//: 생성자가 없음
		//: 생성자가 없는 경우는 크게 두 가지로 나눠짐
		// 1.일회용 메서드와 필드만 존재하는 경우
		// 2.생성을 해주는 메서드가 존재하는 경우
		
		//Math 클래스 - 1번에 해당됨 (이유는 전부 다 static 이기 때문)
		
		//Q. 다음 두 자동차의 속도 차이는 얼마일까요?
		int car1 = 55, car2 = 70;
		int diff = Math.abs(car1-car2); //절대값(absolute value)
		System.out.println("차이 : "+diff);
		
		//올림, 버림, 반올림
		double v1 = 1.4;
		double v2 = 1.5;
		
		//System.out.println((int)(v1+0.5)); //함수를 모를 때의 반올림 방법(지양)
		System.out.println("반올림 : "+Math.round(v1));
		System.out.println("반올림 : "+Math.round(v2));
		
		System.out.println("올림 : "+Math.ceil(v1));
		System.out.println("올림 : "+Math.ceil(v2));
		
		System.out.println("버림 : "+Math.floor(v1));
		System.out.println("버림 : "+Math.floor(v1));
		
		System.out.println("2의10승 : "+Math.pow(2,10));
//		int acc = 1;
//		for(int i=0; i<10; i++) {
//			acc *= 2;
//		} System.out.println("2의10승 : "+acc); //함수를 모를 때의 제곱 방법(지양)
	}

}
