package api.io.single;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test06파일복사03 {

	public static void main(String[] args) throws IOException {
		
		//준비
		File readTarget = new File("sample/origin.txt");
		File writeTarget = new File("sample/copy.txt");
		
		FileInputStream in = new FileInputStream(readTarget);
		BufferedInputStream inBuf = new BufferedInputStream(in);
		//따로 버퍼의 크기를 지정하지 않으면 기본적으로 8192로 지정 : 가장 효율적인 버퍼 크기
		
		FileOutputStream out = new FileOutputStream(writeTarget);
		BufferedOutputStream outBuf = new BufferedOutputStream(out);
		//따로 버퍼의 크기를 지정하지 않으면 기본적으로 8192로 지정 : 가장 효율적인 버퍼 크기
		
		byte[] data = inBuf.readAllBytes(); //버퍼를 사용해서 다 읽으세요
		outBuf.write(data); //읽은 내용을 다 내보내세요
		
		inBuf.close(); outBuf.close();
	}
}