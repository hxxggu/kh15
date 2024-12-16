package api.lang.object;

public class Test07욕설필터링02 {

	public static void main(String[] args) {

		String line = "이런 신발끈 수박씨 개나리같은 십장생을 보았나";
		
		//line에 대한 변경 처리
		line = line.replace("개나리", "***");
		line = line.replace("십장생", "***");
		line = line.replace("신발끈", "***");
		line = line.replace("수박씨", "***");
		line = line.replace("시베리아", "***");
		line = line.replace("조카", "***");
		line = line.replace("주옥", "***");
		line = line.replace("시방", "***");
		
		System.out.println(line);
	}
}