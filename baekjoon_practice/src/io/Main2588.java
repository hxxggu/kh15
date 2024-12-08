package io;

import java.util.Scanner;

public class Main2588 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int num3 = num1*(num2%10);
		System.out.println(num3);
		
		int num4 = num1*(num2%100/10);
		System.out.println(num4);
		
		int num5 = num1*(num2%1000/100);
		System.out.println(num5);
		
		int num6 = num1*num2;
		System.out.println(num6);
	}

}
