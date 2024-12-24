
package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test06파일복사02 {

	public static void main(String[] args) throws IOException {
		
		//준비
		File readTarget = new File("sample/origin.txt");
		File writeTarget = new File("sample/copy.txt");
		
		byte[] buffer = new byte[8192];
		//컴퓨터에서는 2진수로 바이트 공간을 지정할 수록 공간의 효율성 때문에 처리 속도가 제일 빠름
		
		FileInputStream in = new FileInputStream(readTarget);
		FileOutputStream out = new FileOutputStream(writeTarget);
		
		//전부 복사
		long begin = System.currentTimeMillis();
		while(true) {
			int size = in.read(buffer); //buffer에 읽고 size에 읽은 크기 저장
			if(size == -1) break;
			out.write(buffer, 0, size); //0부터 size개만큼 내보내세요
		}
		long end = System.currentTimeMillis();
		System.out.println("소요시간 : " + (end-begin) + "ms");
		
		out.close(); in.close();
	}
}
