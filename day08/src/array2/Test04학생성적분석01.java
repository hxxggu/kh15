package array2;

public class Test04학생성적분석01 {

	public static void main(String[] args) {
		//입력
		int[][] scoreList = new int[][] {
			{77, 85, 86, 92, 60},
			{80, 82, 55, 95, 85},
			{90, 92, 85, 70, 67}
		};
		
		//1. 반마다 구분하여 출력
		for(int i=0; i<scoreList.length; i++) {
			System.out.println("< 반 정보 "
					+ ">");
			for(int j=0; j<scoreList[i].length; j++) {
				System.out.println("점수 : "+scoreList[i][j]+"점");
			}
		}
		
		//2. 반마다 성적 우수자만 출력
		for(int i=0; i<scoreList.length; i++) {
			System.out.println("< 성적 우수자 정보 >");
			for(int j=0; j<scoreList[i].length; j++) {
				if(scoreList[i][j] >= 90) {
					System.out.println("점수 : "+scoreList[i][j]+"점");
				}
			}
		}
		
		//3. 반마다 재평가자 인원 수 출력
		int[] fail = new int[3]; //카운트를 배열로 생성
		for(int i=0; i<scoreList.length; i++) {
			System.out.println("< 각 반 재평가자 인원 수 >");
			for(int j=0; j<scoreList[i].length; j++) {
				if(scoreList[i][j] < 70) {
					fail[i]++;
				}
			}
		}
		for(int i=0; i<fail.length; i++) {
			System.out.println("재평가자 : "+fail[i]+"명");
		}
		
		//4. 반 평균을 출력
		int[] total = new int[3];
		float[] avg = new float[3];
		
		for(int i=0; i<scoreList.length; i++) {
			for(int j=0; j<scoreList[i].length; j++) {
				total[i] += scoreList[i][j];
			}
			avg[i] = (float)total[i] / scoreList[i].length;
		}
		System.out.println("< 각 반 평균 >");
		for(int i=0; i<avg.length; i++) {
			System.out.println("반 평균 : "+avg[i]+"점");
		}
	}
}
