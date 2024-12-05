package io;

import java.util.Scanner;

//자동 import = ctrl+shift+o

public class Test02표준입력 {
	public static void main(String[] args) {
		//표준입력
		//: 표준 입력 통로(System.in)를 이용하는 명령
		//: 기본으로 제공되는 명령으로는 한글자씩 밖에 못읽음
		//: 추가 도구를 사용하여 글자를 모아 원하는 형태로 변환하도록 처리
		//: Scanner, BuffereReader,…
		
		//[1]도구 생성
		Scanner sc=new Scanner(System.in);
		
		int a=sc.nextInt(); //sc를 이용해서 정수 한 개를 입력받으시오
		System.out.println("a="+a);
		
		long b=sc.nextLong(); //sc를 이용해서 long 한 개를 입력받으시오
		System.out.println("b="+b);
		
		float c = sc.nextFloat(); //sc를 이용해서 float 한 개를 입력받으시오
		System.out.println("c="+c);
		
		double d=sc.nextDouble(); //sc를 이용해서 double 한 개를 입력받으시오
		System.out.println("d="+d);
		
		String e=sc.next(); //sc를 이용해서 String 한 개를 입력받으시오
		System.out.println("e="+e);
	}
	
}
