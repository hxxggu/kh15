package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01예외처리의필요성 {

	public static void main(String[] args) {
		//try~catch 구문
		//: try는 플랜 A에 대한 코드를 작성
		//: catch는 플랜 B에 대한 코드를 작성
		
		try {//Plan A
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액 : ");
		int money = sc.nextInt();
		
		System.out.print("인원수 : ");
		int people = sc.nextInt();
		
		int div = money / people;
		int mod = money % people;
		
		System.out.println("1인당 금액 : "+div+"원");
		System.out.println("자투리 금액 : "+mod+"원");
		}
		
		catch(ArithmeticException e){ //Plan B
			System.err.println("인원수는 0이 될 수 없습니다");
		}
		
		catch(InputMismatchException e){ //Plan B
			System.err.println("숫자 입력이 잘못되었습니다");
		}
	}
}
