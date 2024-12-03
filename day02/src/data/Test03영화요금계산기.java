package data;

public class Test03영화요금계산기 {

	public static void main(String[] args) { // 준비(입력)
		int adultPrice = 15000;
		int teenPrice = 10000;
		
		int adultCnt = 2;
		int teenCnt = 3;
		
		// 계산(처리/연산)
		int adultTotal = adultPrice*adultCnt;
		int teenTotal = teenPrice*teenCnt;
		int result = adultTotal + teenTotal;
				
		System.out.println("총 금액은 "+ result + "원입니다."); // 표시(출력)
	}
	
}
