package array2;

public class Test02이차원배열 {

	public static void main(String[] args) {
		
		//2차원 배열
		//: 표와 같은 모양을 가지는 배열
		//: 1차원 배열을 모아둔 상태
		
		//Ex. 2개 반에서 각각 3명씩의 성적 정보
		int[][] a = new int[2][3]; //높은 차원을 더 먼저 기재함 (반>학생)
		//a   ---->   [0]   ---->   [0][0][0]
		//            [1]   ---->   [0][0][0]
		
		int[][] b = new int[][] {
			{50, 60, 70},
			{80, 50, 65}
		};
		
		//b   ---->   [0]   ---->   [50][60][70]
		//            [1]   ---->   [80][50][65]
		System.out.println(b); //결과값 : [[I@65ae6ba4 >> [[: 2차원배열 의미, 65ae6ba4: 일련번호
		System.out.println(b[0]);
		System.out.println(b[1]);
		
		System.out.println(b[0][0]);
		System.out.println(b[0][0]);
		System.out.println(b[0][0]);
		System.out.println(b[0][0]);
		System.out.println(b[0][0]);
		System.out.println(b[0][0]);
		System.out.println(b[0][0]);
	}
}
