package api.io.file;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01파일제어 {

	public static void main(String[] args) {
		File f1 = new File("dummy");
//		File f1 = new File("D:\\kh15\\github\\kh15\\day16\\dummy");
		
		System.out.println("실제로 있어요? " + f1.exists());
		if(f1.exists()) {
			System.out.println("파일명 : " + f1.getName());
			System.out.println("파일의 위치 : " + f1.getPath());
			System.out.println("파일의 절대 위치 : " + f1.getAbsolutePath());
			System.out.println("파일 크기 : " + f1.length()+ " bytes");
			
			long time = f1.lastModified(); //수정시각
			System.out.println("최종 수정 시각 : " + time);
			//형식 변환하여 출력
			Date date = new Date(time);
			Format fmt = new SimpleDateFormat("y년 M월 d일 H시 m분 s초");
			System.out.println("최종 수정 시각 : " + fmt.format(date));
			
			System.out.println("쓰기 가능? " + f1.canWrite());
			System.out.println("숨겨져 있나? " + f1.isHidden());
		}
	}
}
