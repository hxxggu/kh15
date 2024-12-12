package oop.constructor2;

import java.util.Scanner;

public class Test01캐릭터생성 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("직업(전사/성직자/도둑) : ");
		//사용자에게 최소한의 입력값을 줄 수록 개발자에게 편리
		//직업에 대해서 번호를 선택하게 하는 방법도 있음
		String job = sc.next();
		
		Player p = new Player(id, job);
		p.show();
		
	}
}
