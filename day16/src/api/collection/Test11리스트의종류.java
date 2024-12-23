package api.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Test11리스트의종류 {
	public static void main(String[] args) {
		//선형구조
		//: 저장소의 시작과 끝이 명확한 형태
		List<String> a =new ArrayList<>(); //배열형태, 조회에 특화
		List<String> b =new LinkedList<>(); //연결형태, 추가/삭제에 특화
		List<String> c =new Vector<>(); //과거에 사용하던 저장소(느림, 전부 다 Thread safe)
		//Thread safe: 동시에 한명밖에 못하는 형태 (Ex. 화장실) / 데이터를 하나씩만 처리가 가능함
		
		a.add("피카츄");	b.add("피카츄");
		a.add("라이츄");	b.add("라이츄");
		a.add("파이리");	b.add("파이리");
		a.add("꼬부기");	b.add("꼬부기");
		
		System.out.println(a);
		System.out.println(b);
		
		//다른 저장소의 데이터를 기반으로 저장소 생성이 가능
		List<String> d = new LinkedList<>(a); //a의 모든 데이터로 d 생성
		List<String> e = new ArrayList<>(b); //b의 모든 데이터로 e 생성
		System.out.println(d);
		System.out.println(e);
		
		//저장소끼리 연산하는 것을 집합연산이라고 일컫음
		//DeleteAll : 기존 리스트에서 주어진 리스트와 겹치는 부분을 모두 제거하라
		
		//선형구조 : 시작과 끝이 있는 구조
		//빅-세타(가장 빨리 찾았을 때) : 1회
		//빅-오메가(평균) : 3.5회
		//빅-오(가장 늦게 찾았을 때) : 6회
		
		//비선형 구조 : 시작과 끝이 불명확한 구조
		//: Tree / Hash / Graph
		//tree : 작은 것을 왼쪽, 큰 것을 오른쪽에 배치 / 빅-세타(최소): 1번, 빅-오메가(최대): 3번
		//hash : 구분만 최대한 빠르게 / 빅-세타(최소) : 1회, 빅-오메가 : 3번
		//단순한 찾기는 hash가 훨씬 빠름, 많은 에너지가 들지만 효과가 좋음
		//구조의 그림이 이상해질 수록 비선형 구조에 가까움
		
		
		
		
		
		
	}
}
