package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test02멀티바이트입력 {
	public static void main(String[] args) throws IOException {
		
		//멀티바이트 입력은 출력의 반대되는 준비물이 필요하다
		File target = new File("sample", "multi.txt");
		
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		DataInputStream data = new DataInputStream(buffer);
		
		//[프로그램] ← data ← buffer ← in ← target ← [실제파일]
		
		//(주의) 반드시 작성 순서대로 읽어와야 한다
		int a = data.readInt(); // 파일에서 4조각을 읽어 int로 복원하라
		double b = data.readDouble(); // 파일에서 8조각을 읽어 double로 복원하라
		long c = data.readLong(); // 파일에서 8조각을 읽어 long으로 복원하라
		char d = data.readChar(); // 파일에서 2조각을 읽어 char로 복원하라
		float e = data.readFloat(); // 파일에서 4조각을 읽어 float으로 복원하라
		
		data.close();
		
		//불러온 데이터 확인
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);
	}
}
