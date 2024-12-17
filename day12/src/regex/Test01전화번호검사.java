package regex;

public class Test01전화번호검사 {
	public static void main(String[] args) {
		
		String phone = "01012345678";
		
//		String regex = "^010[1234568789][0123456789][0123456789][0123456789][0123456789][0123456789][0123456789][0123456789]$";
//		String regex = "^010[1-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$";
//		phone이 regex의 패턴에 부합하는지 검사한 뒤 출력
		String regex = "^010[1-9][0-9]{7}";
		System.out.println(phone.matches(regex));
	}
}