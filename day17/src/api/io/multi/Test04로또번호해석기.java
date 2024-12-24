package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test04로또번호해석기 {
	public static void main(String[] args) throws IOException {

		File target = new File("sample", "lotto.kh");
		
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream bufferIn = new BufferedInputStream(in);
		DataInputStream dataIn = new DataInputStream(bufferIn);
		
		int printLotto = dataIn.readInt();
		System.out.println(printLotto);
		dataIn.close();
	}
}
