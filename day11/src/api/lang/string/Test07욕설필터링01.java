package api.lang.string;

public class Test07욕설필터링01 {

	public static void main(String[] args) {
		
		//난이도 떨어뜨리기
		//"개나리", "십장생" 변경하기
		
//		System.out.print("필터링할 문장을 입력하세요 : ");
		String line = "이런 신발끈 수박씨 개나리같은 십장생을 보았나";
		
		//line에 대한 변경 처리
		line = line.replace("개나리", "***");
		line = line.replace("십장생", "***");
		
		System.out.println(line);
	}
}