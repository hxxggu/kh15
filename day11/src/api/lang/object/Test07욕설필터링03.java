package api.lang.object;

public class Test07욕설필터링03 {

	public static void main(String[] args) {

		String[] filter = new String[] {
				"개나리", "십장생", "신발끈", "수박씨",
				"시베리아", "조카", "주옥", "시방"
		};
		
		String line = "이런 신발끈 수박씨 개나리같은 십장생을 보았나";
		
		//line에 대한 변경 처리
		line = line.replace(filter[0], "***");
		line = line.replace(filter[1], "***");
		line = line.replace(filter[2], "***");
		line = line.replace(filter[3], "***");
		line = line.replace(filter[4], "***");
		line = line.replace(filter[5], "***");
		line = line.replace(filter[6], "***");
		line = line.replace(filter[7], "***");
		
		System.out.println(line);
	}
}