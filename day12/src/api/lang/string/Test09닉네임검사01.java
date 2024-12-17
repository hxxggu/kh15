package api.lang.string;

public class Test09닉네임검사01 {

	public static void main(String[] args) {
		
		//입력
		String nickname = "테스트닉네임12";
		
		//처리
		//1.닉네임 글자수가 2~10글자인지 검사
		boolean lengthOk = nickname.length()>=2 && nickname.length()<=10;
//		System.out.println("lenghOk = "+lengthOk);
		
		//2.닉네임이 한글 또는 숫자로만 이루어져 있는지 검사
		int cnt = 0;
		for(int i=0; i<nickname.length();i++) {
			char ch = nickname.charAt(i);
			if(ch>='가' && ch<='힣') {
				cnt++;
			} else if(ch>='0' && ch<='9') cnt++;
		}// System.out.println("cnt = "+cnt);
		boolean korAndNumOk = cnt==nickname.length();
//		System.out.println("korAndNumOk = "+korAndNumOk);
		
		//3.닉네임에 "운영자" 포함 금지
//		boolean notContainAdmin = nickname.contains("운영자")==false;
		boolean notContainAdmin = !nickname.contains("운영자"); //위아래 둘다 같은 의미지만 아래 코드 선호
//		System.out.println("notContainAdmin = "+notContainAdmin);
		
		//4.첫 글자가 숫자일 수 없다 (첫 글자가 한글이어야 한다)
		char first = nickname.charAt(0);
		boolean firstIsNotNum = !(first>='0' && first<='9');
//		System.out.println("firstIsNotNum = "+firstIsNotNum);
		
		boolean valid = lengthOk && korAndNumOk && notContainAdmin && firstIsNotNum;
		
		if(valid == true) {
			System.out.println("닉네임 설정 완료");
		} else {
			//System.out.println("이미 사용중인 닉네임입니다");
			System.out.println("닉네임 형식에 맞지 않습니다");
		}
	}
}