package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03파일복사 {
	public static void main(String[] args) throws IOException {
		//Q. sample/origin.txt를 sample/copy.txt로 복사하십시오
		
		
		//1단계 : 한글자만 복사 (h)
		
		//준비 : 입력용 파일, 입력용 통로, 출력용 파일, 출력용 통로
		
		File readTarget = new File("sample/origin.txt");
		File writeTarget = new File("sample/copy.txt");
		
		if(!readTarget.exists()) {
			System.err.println("대상이 존재하지 않습니다");
			System.exit(-1);
		}
		
		//통로 생성
		FileInputStream in = new FileInputStream(readTarget);
		FileOutputStream out = new FileOutputStream(writeTarget);
		//readTarget → in → [프로그램] → out → writeTarget
		
		int value = in.read();
		out.write(value);
		
		//통로 정리
		in.close();
		out.close();
	}
}
