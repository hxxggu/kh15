package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test06파일복사01 {

	public static void main(String[] args) throws IOException {
		
		//준비
		File readTarget = new File("sample/origin.txt");
		File writeTarget = new File("sample/copy.txt");
		
		byte[] buffer = new byte[10];
		
		FileInputStream in = new FileInputStream(readTarget);
		FileOutputStream out = new FileOutputStream(writeTarget);
		
		//전부 복사
		while(true) {
			int size = in.read(buffer); //buffer에 읽고 size에 읽은 크기 저장
			if(size == -1) break;
			out.write(buffer, 0, size); //0부터 size개만큼 내보내세요
		}
		out.close(); in.close();
	}
}
