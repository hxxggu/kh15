package array2;

public class Test04학생성적분석 {

	public static void main(String[] args) { //3개반의 5명의 학생 : classroom[3][5]
		int[][] classroom = new int[][] {
			{77, 85, 86, 92, 60},
			{80, 82, 55, 95, 85},
			{90, 92, 85, 70, 67}
		};
		
		//1. 모든 반 학생 성적 반마다 구분 출력
		for(int i=0; i<classroom.length; i++) {
			
			System.out.println("[ 각 반 학생 점수 ]");
			for(int j=0; j<5; j++) {
				System.out.print(classroom[i][j]+"점 ");
			} System.out.println();
		}
		
		//2. 성적 우수자를 반마다 구분하여 출력
		for(int i=0; i<classroom.length; i++) {
			System.out.println("[ 성적 우수자 점수 ]");
			for(int j=0; j<classroom[i].length; j++) {
				if(classroom[i][j] >= 90) {
					System.out.print(classroom[i][j]+"점 ");
				}
			} System.out.println();
		}
		
		//3. 재평가자 학생 인원수 반마다 세어서 출력
		int cnt = 0;
		for(int i=0; i<classroom.length; i++) {
			System.out.println("[ 재평가자 인원 수]");
			for(int j=0; j<classroom[i].length; j++) {
				if(classroom[i][j] < 70) {
					cnt++;
				}
			}
			System.out.println(cnt+"명");
			cnt = 0;
		}
		
		//4. 반마다 평균 점수 구하여 출력
		float sum = 0, avg = 0;
		for(int i=0; i<classroom.length; i++) {
			System.out.println("[ 반 평균 ]");
			sum = 0;
			for(int j=0; j<classroom[i].length; j++) {
				sum = sum + classroom[i][j];
			}
			avg = sum/classroom[i].length;
			System.out.println(avg+"점");
		}
	}
}
