package api.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02시간출력형식 {
	public static void main(String[] args) {
		
		while(true) {
			Date a1 = new Date();
			SimpleDateFormat smt1 = new SimpleDateFormat("yyyy년 MM월 dd일 a h시 m분 s초");
			System.out.println(smt1.format(a1));
			
			Date a2 = new Date();
			SimpleDateFormat smt2 = new SimpleDateFormat("yyyy-MM-dd E H:m:s");
			System.out.println(smt2.format(a2));
		}
	}
}
