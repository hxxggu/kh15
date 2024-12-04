package data3;

public class Test05숫자판정프로그램 {
	public static void main(String[] args) {
		//Q. 두 자리 정수가 다음과 같은 형태로 주어졌을 때, 문제의 요구사항에 부합하는지 판정하여 출력하세요
		//1. 이 숫자가 짝수인지
		//2. 이 숫자가 3의 배수인지
		//3. 이 숫자에 7이 들어있는지
		
		int num=77;
		
		boolean even=(num%2==0);
		System.out.println(even);
		
		boolean three=(num%3==0);
		System.out.println(three);
		
		int firstNum=num/10;
		int secNum =num%10;
		boolean seven=(firstNum<8&&firstNum>6)||(secNum<8&&secNum>6); //방법1
		System.out.println(seven);
		
		//boolean seven=(num/10==7)||(num%10==7); 방법2
		
	}
}
