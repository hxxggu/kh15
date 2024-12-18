package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01예외처리의필요성3 {

	public static void main(String[] args) {
		//예외는 종류가 다양한데 통합해서 처리가 가능한가?
		//: 통합 예외 처리는 Exception
		
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
//			catch(Object e) { //error (사용불가)
//			catch(Throwable e) { //에러까지 처리 (남의 코드 실행 시 사용)
			catch(Exception e) { //최상위 예외 (예외의 아버지/어머니)
//			catch(RuntimeException e) {
			System.err.println("입력이 잘못되었습니다");
		}
	}
}
