package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03파일복사3 {
	public static void main(String[] args) throws IOException {
		//Q. sample/origin.txt를 sample/copy.txt로 복사하십시오
		
		
		//1단계 : 한글자만 복사 (h)
		//2단계 : 반복문
		
		//준비 : 입력용 파일, 입력용 통로, 출력용 파일, 출력용 통로
		
		File readTarget = new File("D:\\kh15\\eclipse\\eclipse.exe");
		File writeTarget = new File("D:\\kh15\\eclipse\\eclipse_copy.exe");
		
		if(!readTarget.exists()) {
			System.err.println("대상이 존재하지 않습니다");
			System.exit(-1);
		}
		
		//통로 생성
		FileInputStream in = new FileInputStream(readTarget);
		FileOutputStream out = new FileOutputStream(writeTarget);
		//readTarget → in → [프로그램] → out → writeTarget
		
		
		long size = readTarget.length();
		long cnt = 0L;
		
		while(true) {
			int value = in.read();
			if(value == -1) break; //EOF
			out.write(value);
			cnt++;
			float percent = cnt*100f/size;
			System.out.println(cnt + "/" + size);
		}
		
		//통로 정리
		in.close();
		out.close();
	}
}
