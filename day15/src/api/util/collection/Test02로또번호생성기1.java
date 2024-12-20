package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test02로또번호생성기1 {
	public static void main(String[] args) {
		Random r = new Random();
		List<Integer> lottoNumbers = new ArrayList<>(); // 숫자 저장소
		
		//: 숫자가 6개가 될 때까지 반복하는 반복문
		while(lottoNumbers.size() < 6) {
			int num = r.nextInt(45)+1; //1부터 45개
			
//			if(lottoNumbers.contains(num) == false) { //존재하지 않는 번호면/
			if(!lottoNumbers.contains(num)) {
				lottoNumbers.add(num); //추가하세요
			}
		}
		System.out.println(lottoNumbers);
	}
}