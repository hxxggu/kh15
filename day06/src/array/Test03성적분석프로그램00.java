package array;

import java.util.Arrays;

public class Test03성적분석프로그램00 {

	public static void main(String[] args) {
		int[] score = new int[] {77, 82, 95, 91, 65, 87, 68, 85, 82, 90};
		
		System.out.print("총 학생의 각 점수 : ");
		for(int i=0; i<10; i++) {
			System.out.print(score[i]+"점 ");
		} System.out.println();
		
		System.out.print("성적 우수자 점수 (90점 이상) : ");
		for(int i=0; i<10; i++) {
			if(score[i] >= 90) {
				System.out.print(score[i]+"점 ");
			}
		} System.out.println();
		
		System.out.print("재평가 대상자 점수 (70점 미만) : ");
		for(int i=0; i<10; i++) {
			if(score[i] < 70) {
				System.out.print(score[i]+"점 ");
			}
		} System.out.println();
		
		int sum = 0, stdNum = 0;
		for(int i=0; i<10; i++) {
			sum += score[i];
			stdNum++;
		}
		double avg = (double)sum/stdNum;
		System.out.print("전체 학생의 점수 평균 : "+avg+"점\n");
		
		//추가문제
		//score[] = 85;
		System.out.println(Arrays.toString(score));
		//큰 순서대로 정렬
		for(int i=0; i<score.length; i++) {
			int target = score[i];
			for(int j=1; j<score.length; j++) {
				while(target<score[j]) {
					score[j] = score[j-1];
				}
			}
		} System.out.println(Arrays.toString(score));
		
	}
}
