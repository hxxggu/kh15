package api.lang.string;

public class Test07욕설필터링04 {

	public static void main(String[] args) {

		String[] filter = new String[] {
				"개나리", "십장생", "신발끈", "수박씨",
				"시베리아", "조카", "주옥", "시방"
		};
		
		String line = "이런 시베리아 신발끈 수박씨 개나리같은 십장생을 보았나";
		String star = "X";
		
		//line에 대한 변경 처리
		for(int i=0; i<filter.length; i++) {
			int size = filter[i].length(); //글자수를 확인
			line = line.replace(filter[i], star.repeat(size));
		}
		System.out.println(line);
	}
}