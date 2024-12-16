package api.lang.object;

public class Test07욕설필터링05 {

	public static void main(String[] args) {

		String[] filter = new String[] {
				"개나리", "십장생", "신발끈", "수박씨",
				"시베리아", "조카", "주옥", "시방"
		};
		
		String line = "이런 신발끈 수박씨 개나리같은 십장생을 보았나";
		
		//line에 대한 변경 처리
		for(int i=0; i<filter.length; i++) {
			line = line.replace(filter[i], "***");	
		}
		
		System.out.println(line);
	}
}