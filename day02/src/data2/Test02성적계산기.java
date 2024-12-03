package data2;

public class Test02성적계산기 {
	public static void main(String[] args) {
		//Q. 어떤 학생의 중간고사 성적이 다음과 같을 때, 이 학생의 총 점수과 과목별 평균은?
		//국어 65점, 영어 70점, 수학 80점
		//입력
		int kor = 65;
		int eng = 70;
		int math = 80;
		
		//처리
		int sum = kor+eng+math;
		//double avg = sum/3.0f;
		//float avg = sum/3f;
		float avg = (float)sum/3; //변환연산(cast 연산)
		
		//출력
		System.out.println("총 점수는 "+sum+"점, 평균 점수는 "+avg+"점입니다.");
	}
}
