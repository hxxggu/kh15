package array;

public class Test03성적분석프로그램 {

	public static void main(String[] args) {
		int[] score = new int[] {77, 82, 95, 91, 65, 87, 68, 85, 82, 90};
		
		System.out.print("총 학생의 각 점수 : ");
		for(int i=0; i<10; i++) {
			System.out.print(score[i]+"점 ");
		}
		
		System.out.print("성적 우수자 점수 (90점 이상): ");
		for(int i=0; i<10; i++) {
			if(score[i] >= 90) {
				System.out.println(score[i]+"점 ");
			}
		}
		
		System.out.print("재평가 대상자 점수 (70점 미만) : ");
		for(int i=0; i<10; i++) {
			if(score[i] < 70) {
				System.out.println(score[i]+"점 ");
			}
		}
		
		int avg = 0;
		System.out.print("전체 학생의 점수 평균 : ");
		for(int i=0; i<10; i++) {
			
			
		} System.out.println(score[i]+"점 ");
	}

}
