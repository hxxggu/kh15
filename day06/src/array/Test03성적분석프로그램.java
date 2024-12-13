package array;

import java.util.Arrays;

public class Test03성적분석프로그램 {

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
		int stdScore = 85, grade = 1;
		for(int i=0; i<score.length; i++) {
			if(score[i] > stdScore) {
				grade++;
			}
		}
		System.out.println("전학생의 예상 등수는 "+grade+"등 입니다.");
	}
}
