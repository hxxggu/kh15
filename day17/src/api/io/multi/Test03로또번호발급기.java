package api.io.multi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03로또번호발급기 {
	public static void main(String[] args) throws IOException {
		
		File target = new File("sample", "lotto.kh");
		
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream bufferOut = new BufferedOutputStream(out);
		DataOutputStream dataOut = new DataOutputStream(bufferOut);
		
		int lottoNum = 0;
		for(int i=0; i<6; i++) {
			if(1<=lottoNum && lottoNum<=32) {
				dataOut.writeInt(i);
			}
		} dataOut.close();		
	}
}
