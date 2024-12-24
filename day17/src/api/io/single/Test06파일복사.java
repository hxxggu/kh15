package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test06파일복사 {

	public static void main(String[] args) throws IOException {
		
		File readTarget = new File("sample/origin.txt");
		File writeTarget = new File("sample/copy.txt");
		
		if(!readTarget.exists()) {
			System.err.println("대상이 존재하지 않습니다");
			System.exit(-1);
		}
		
		FileInputStream in = new FileInputStream(readTarget);
		FileOutputStream out = new FileOutputStream(writeTarget);
		
		byte[] buffer = new byte[5];
		byte[] space = new byte[16];
		in.read(buffer);
		space.equals(' ');
		out.write(buffer);
		out.write(space);
		
		in.close();
		out.close();
	}
}
