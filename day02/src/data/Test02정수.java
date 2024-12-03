package data;

public class Test02정수 {
	public static void main(String[] args) {
		// 정수 : 소수점이 없는 수 (byte/int/short/long)
		// 아무 표시가 없으면 int로 판단
		// 각 형태마다 표시할 수 있는 크기가 다름 (Ex. byte a = 1000; (X))
		int a=1000;
		int b=2000;
		int c=a+b;
		System.out.println(c);
		
		//(Q) 자장면 한그릇 6,000원일 때, 5그릇의 가격은?
		int menu=6000;
		int cnt=5;
		int price=menu*cnt;
		System.out.println("총 가격은 "+price+"원 입니다.");
	}
}
