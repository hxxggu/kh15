package api.exception;

import java.util.Date;

public class Test02만나이계산기 {
	
	public static void main(String[] args) {


		//Plan A
		String birth = "2020-10";
		
		int year = Integer.parseInt(birth.substring(0,4));
		int month = Integer.parseInt(birth.substring(5,7));
//		int month = Integer.parseInt(birth.substring(5)); //위와 아래의 month는 동일한 의미
		
		System.out.println("year : "+year);
		System.out.println("month : "+month);
	}

}
