package condition;

public class Test04다중조건 {
	public static void main(String[] args) {
		//다중조건 (조건그룹)
		//: 따져야 되는 경우가 많은 상황
		
		//Ex. 월에 따른 계절 출력
		int month = 6;
		
		if(month==3 || month==4 || month==5) {
			System.out.println("봄");	
		} else if(month==6 || month==7 || month==8) {
				System.out.println("여름");
			} else if(month==9 || month==10 || month==11) {
					System.out.println("가을");
				} else {
					System.out.println("겨울");
				}
	}
}