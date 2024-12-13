package array;

public class Test01배열만들기 {

	public static void main(String[] args) {
		//배열(array)
		//: 같은 종류의 데이터를 여러 개 보관하기 위한 저장소
		
		//Ex. 다섯 명의 시험 점수를 보관(80, 70, 90, 85, 60)
		//-> 변수 다섯 개를 만들어서 처리할 수 있다
		
		int a = 80, b = 70, c = 90, d = 85, e = 60;
		System.out.println("점수 : "+a);
		System.out.println("점수 : "+b);
		System.out.println("점수 : "+c);
		System.out.println("점수 : "+d);
		System.out.println("점수 : "+e);
		
		//-> 배열 한 개를 만들어서 처리할 수 있다(참조형)
		//score---------------->[80][70][90][85][60]
		int[] score = new int[] {80, 70, 90, 85, 60};
		System.out.println("score : "+score); //리모컨 출력(일련번호 나옴)
//		System.out.println("점수 : "+score[0]); //+0지점 출력
//		System.out.println("점수 : "+score[1]); //+1지점 출력
//		System.out.println("점수 : "+score[2]); //+2지점 출력
//		System.out.println("점수 : "+score[3]); //+3지점 출력
//		System.out.println("점수 : "+score[4]); //+4지점 출력
		
		for(int i=0; i<=4; i++) {
			System.out.println("점수 : "+score[i]);
		}
	}
}
