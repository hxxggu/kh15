package array;

public class Test04배열생성방법 {

	public static void main(String[] args) {
		//배열 생성 방법은 두 가지가 있다
		//1. 데이터를 지정해서 생성하는 방법
		//2. 크기를 지정해서 생성하는 방법
		
		//1
		int[] a = new int[] {10, 20, 30, 40, 50};
		
		//2
		//int[] b = new int[] {0, 0, 0, 0, 0};
		int[] b = new int[5];
		//b=10; //error(리모컨에는 값을 넣을 수 없음)
		b[0] = 10;
		b[1] = 20;
		b[2] = 30;
		b[3] = 40;
		b[4] = 50;
		//b[5] = 60; //error(범위초과)
		
		
	}

}
