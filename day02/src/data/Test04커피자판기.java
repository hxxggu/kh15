package data;

public class Test04커피자판기 {

	public static void main(String[] args) {
		int ame = 2500;
		int latte = 3000;
		
		int ameCnt = 15;
		int latteCnt = 23;
		
		int ameTotal = ame*ameCnt;
		int latteTotal = latte*latteCnt;
		
		int result = ameTotal + latteTotal;
		
		System.out.println("총 금액은 "+result+"원 입니다.");
	}
}
