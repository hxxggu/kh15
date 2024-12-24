package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test03 {
	public static void main(String[] args) throws IOException {
		//로또 번호 준비(비복원추출)
		List<Integer> nums = new ArrayList<>();
		for(int i=1; i <= 45; i++) {
			nums.add(i);
		}
		
		Collections.shuffle(nums);
		
		List<Integer> lottoNums = nums.subList(0, 6);
		System.out.println(lottoNums);
		
		Set<Integer> sortedNums = new TreeSet<>(lottoNums);
		System.out.println(sortedNums);
		
		//파일 출력(저장)
		File target = new File("sample", "lotto.kh");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		DataOutputStream data = new DataOutputStream(buffer);
//		DataOutputStream data = new DataOutputStream(
//				new BufferedOutputStream(new FileOutputStream(target)));
		
//		for(int i=0; i < sortedNumbers.size(); i++) {}
		for(int num : sortedNums) {
			data.writeInt(num);
		}
		
		data.close();
		System.out.println("로또 번호 생성 완료");
	}
}