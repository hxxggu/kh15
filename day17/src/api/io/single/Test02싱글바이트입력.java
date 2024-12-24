package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test02싱글바이트입력 {
	public static void main(String[] args) throws IOException, InterruptedException {
		//준비물 : 제어용 파일, 입력용 통로
		File target = new File("sample", "single.txt");
		FileInputStream in = new FileInputStream(target);
		
		//[프로그램] ← in ← target ← [sample/single.txt]
		
		while(true) {
			int value = in.read();
			if(value == -1) break; //EOF(End Of File) 발견 시 탈출
			System.out.println("value = " + value);
		}
		
		//마지막에 통로 정리
		in.close();
	}
}
