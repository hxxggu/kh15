package loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main15552 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 입력
				
		for(int i=1; i<=T; i++) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]); //A입력받기
			int B = Integer.parseInt(input[1]); //B입력받기
			
			bw.write((A+B)+"\n");
		}
		bw.flush(); //BufferedWriter를 flush하고 닫음.
		bw.close();
		br.close();
	}
}