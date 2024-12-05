package condition;

public class Test06여행사프로모션02 {

	public static void main(String[] args) {
		//할인율만 구현
		
		
		//입력
		int month = 5;
		int price = 100000;
		
		//처리
		int rate;
		if(month==3 || month==4 || month==5) { //봄
			rate = 25;
		} else if(month==6 || month==7 || month==8) { //여름
			rate = 5;
		} else if(month==9 || month==10 || month==11) { //가을
			rate = 10;
		} else { //겨울
			rate = 30;
		}
		
		int discount = price*rate/100;
		int result = price-discount;
			
		//출력
		System.out.println("예상 경비 : "+price+"원");
		System.out.println("할인율 : "+rate+"%");
		System.out.println("할인 금액 : "+discount+"원");
		System.out.println("최종 경비 : "+result+"원");
	}

}
