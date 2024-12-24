package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test04_1 {
	public static void main(String[] args) throws IOException {
		
		//불러올 데이터를 저장할 저장소
		List<Integer> lottoNums = new ArrayList<>();
		
		//파일 입력
		File target = new File("sample", "lotto.kh");
		FileInputStream in = new FileInputStream(target);
		//무조건 어떤 과정을 거치든 지나가게 되어있음(필수)
		BufferedInputStream buffer = new BufferedInputStream(in);
		DataInputStream data = new DataInputStream(buffer);
		
		for(int i=0; i<6; i++) {
			int num = data.readInt();
			lottoNums.add(num);
		}
		
		data.close();
		
		//출력
		for(int num : lottoNums) {
			System.out.println("번호 : " + num);
		}		
	}
}
