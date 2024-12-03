package data;

public class Test08편의점계산기 {
	public static void main(String[] args) {
		//Q. 삼각김밥이 1,400원이다. 현재 1+1 행사 중이기 때문에
		//2개를 구매하면 1개가 무료 처리. 금액 계산하는 무인 키오스크 구현.
		int cnt = 1; //총 구입한 개수
		int price = 1400; //단일 가격
		
		int free = cnt/2; //무료 처리되는 개수
		int pay = cnt-free; //유료 처리되는 개수
		
		int totalPrice = pay*price; //총 금액
		
		System.out.println("총 금액 : "+totalPrice+"원"); //총 금액출력
	}
}