package condition;

import java.util.Scanner;

public class Main2884 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt(), M = sc.nextInt();
		
		if(M >= 45) {
			M -= 45;
			System.out.println(H+" "+M);
		} else if(M < 45) {
			M = M+60-45;
			H -= 1;
			if(H<0) {
				H += 24;
				System.out.println(H+" "+M);
			} else {
				System.out.println(H+" "+M);
			}
		}
	}
}
