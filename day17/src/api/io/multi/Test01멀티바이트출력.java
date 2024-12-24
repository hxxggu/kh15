package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01멀티바이트출력 {

	public static void main(String[] args) throws IOException {
		//멀티바이트란 int, long, falat, double처럼
		//1byte보다 크지만 크기가 일정한 데이터들을 말한다
		//-> 분해+임시저장+출력을 단계별로 진행
		
		
		File target = new File("sample", "multi.txt");
		FileOutputStream out = new FileOutputStream(target); //출력도구
		BufferedOutputStream buffer = new BufferedOutputStream(out); //임시저장도구
		DataOutputStream data = new DataOutputStream(buffer);
		
		//[프로그램] → data → buffer → out → target → [실제파일]
		
		data.writeInt(100); //100을 int 형태로 분해하여 출력 (4조각)
		data.writeDouble(100); //100을 double 형태로 분해하여 출력 (8조각)
		data.writeLong(100); //100을 long 형태로 분해하여 출력 (8조각)
		data.writeChar(100); //100을 char 형태로 분해하여 출력 (2조각)
		data.writeFloat(100); //100을 float 형태로 분해하여 출력 (2조각)
		//buffer 크기가 기본으로 8192로 지정되있음 → buffer는 모든 공간을 다 채워야 결과를 출력함
		
		//다 차지 않아도 보내라
//		data.flush(); //전송만
		data.close(); //전송 후 종료
		// 모든 Stream은 close로 닫아주는 것을 습관화 (닫지 않으면 실행이 되지 않는 형태도 있음)
	}

}
