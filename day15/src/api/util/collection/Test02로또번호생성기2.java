package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test02로또번호생성기2 {
	public static void main(String[] args) {
		Random r = new Random(); //랜덤 생성기
		List<Integer> lottoNumbers = new ArrayList<>(); // 숫자 저장소
		
		for(int i=0; i<6; i++) { //6번
			int num = r.nextInt(45)+1; //1부터 45개
			if(!lottoNumbers.contains(num)) { //이미 존재하는 숫자가 아니면
				lottoNumbers.add(num); //추가하세요
			} else { //이미 존재하는 숫자라면
				i--; //반복변수가 늘어나지 않도록 -1 하여 한바퀴 더 돌도록 처리
			}
		}
		System.out.print(lottoNumbers);
	}
}