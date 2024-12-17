package regex;

public class Test03닉네임검사 {
	public static void main(String[] args) {
		
		String nickname = "테스트운영자1";
		
		String regex = "^[가-힣][가-힣0-9]{1,9}$";
		
		if(nickname.matches(regex)) {
			System.out.println("올바른 형식의 닉네임이 아닙니다");
		} else {
			System.out.println("닉네임은 한글로 시작하며 숫자 포함 2~10자로 작성해야합니다");
		}
	}
}
