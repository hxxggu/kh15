package oop.poly2;

import java.util.Scanner;

public class Test01다형성미사용예제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("노트북을 먼저 선택하세요");
		System.out.print("1.맥북  2.갤럭시북  : ");
		int type = sc.nextInt(); //기종(1.맥북 2.갤럭시북)
		
		System.out.println("테스트할 기능을 선택하세요");
		System.out.print("1.전원  2.동영상재생  3.타이핑  : ");
		int action = sc.nextInt(); //기능(1.전원 2.동영상재생 3.타이핑)
		
		if(type == 1) { //맥북
			MacBook01 nb = new MacBook01();
			if(action == 1) nb.power();
			else if(action  == 2) nb.playVideo();
			else nb.typing();
		} else { //갤럭시북
			GalaxyBook01 nb = new GalaxyBook01();
			if(action == 2) nb.power();
			else if(action  == 2) nb.playVideo();
			else nb.typing();
		}
	}
}
