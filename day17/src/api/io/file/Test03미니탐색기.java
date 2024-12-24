package api.io.file;

import java.io.File;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test03미니탐색기 {

	public static void main(String[] args) {
		//경로입력
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		String path = sc.nextLine();
				
		File target = new File(path);
		//target.mkdirs(); //디렉터리 생성
		//target.createNewFile(); //파일 생성
		
		if(target.isFile()) { //파일이라면
			System.out.println("[" + target.getName() + "] 파일정보");
			Format f2 = new DecimalFormat("#, ##0");
			System.out.println("크기 : " + target.length() + "bytes");
			Date d = new Date(target.lastModified());
			Format f = new SimpleDateFormat();
			System.out.println("최종수정시각 : " + f.format(d));
			
		} else if(target.isDirectory()) { //디렉터리라면
			System.out.println("[" + target.getName() + "] 디렉터리 정보");
			File[] files = target.listFiles();
			for(File f : files) {
				System.out.println(f.getName());
				if(f.isFile()) {
					System.out.println("[파일]");
				} else {
					System.out.println("[디렉터리]");
				}
			}
			
		} else { //이도저도 아니라면(존재하지 않는다면)
			System.err.println("파일이 존재하지 않습니다");
		}

	}

}
