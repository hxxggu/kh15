package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test05바이트배열입력2 {
	public static void main(String[] args) throws IOException {
		//바이트를 모아서 입력
		//: 준비물 : 입력용 파일, 입력용 통로, 바이트 배열(카트)
		
		File target = new File("sample/singlearray.txt");
		FileInputStream in = new FileInputStream(target);
		byte[] buffer = new byte[5]; //buffer : 임시저장소
		
		while(true) {
			int size = in.read(buffer); //읽어들인 데이터를 buffer를 가득 채우도록 입력받으세요  (5개씩)
			if(size == -1) break; //EOF
			System.out.println("size = " +size);
			System.out.println(Arrays.toString(buffer)); //arrays : 배열 도우미 / 배열 출력 간소화
		
		}		
	}
}
