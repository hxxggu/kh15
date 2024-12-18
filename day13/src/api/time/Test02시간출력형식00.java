package api.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02시간출력형식00 {
	public static void main(String[] args) {
		Date a = new Date();
		
		//2024년 12월 18일 오후 4시 11분 13초
		SimpleDateFormat smt1 = new SimpleDateFormat("yyyy년 MM월 dd일 a h시 m분 s초");
		System.out.println(smt1.format(a));
			
		//2024-12-18 수 16:11:13
		SimpleDateFormat smt2 = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		System.out.println(smt2.format(a));
	}
}
