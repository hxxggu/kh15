package array2;

public class Test03이차원배열생성문제 {

	public static void main(String[] args) {
		//다음 데이터들을 2차원 배열에 저장하고 출력하시오
		int[][] a = new int[][] { //[3][2]
			{100, 200}, //a[0].length = 2
			{300, 400}, //a[1].length = 2
			{500, 600} //a[2].length = 2
		};
		
		float[][] b = new float[][] { //[2][4]
			{1.2f, 2.3f, 3.4f, 4.5f},
			{2.3f, 3.4f, 4.5f, 5.6f}
		};
		
		String[][] c = new String[][] { //[2][2]
			{"안녕", "hello"},
			{"안녕", "goodbye"}
		};
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<2; j++) {
				System.out.println(a[i][j]);			
			}
		}
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.println(a[i][j]);			
			}
		}
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<4; j++) {
				System.out.println(b[i][j]);			
			}
		}
		
		for(int i=0; i<b.length; i++) {
			for(int j=0; j<b[i].length; j++) {
				System.out.println(b[i][j]);			
			}
		}
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				System.out.println(c[i][j]);			
			}
		}
		
		for(int i=0; i<c.length; i++) {
			for(int j=0; j<c[i].length; j++) {
				System.out.println(c[i][j]);			
			}
		}
	}
}
