package api.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test04차트분석 {
	public static void main(String[] args) {
		Set<String> youtube = Set.of("APT", "HOME SWEET HOME", "Whiplash", "toxic till the end", "내 이름 맑음");
		Set<String> melon = Set.of("HOME SWEET HOME", "APT", "Whiplash", "나는 반딧불", "POWER");
		
		Set<String> gradeAll = new TreeSet<>();
		gradeAll.addAll(youtube);
		gradeAll.retainAll(melon);
		System.out.println("모두 순위권인 곡");
		for(String title:gradeAll){
			System.out.println("- "+title);
		}
		
		Set<String> gradeYoutube = new TreeSet();
		gradeYoutube.addAll(youtube);
		gradeYoutube.removeAll(melon);
		System.out.println("유튜브 단일 순위권인 곡");
		for(String title:gradeYoutube){
			System.out.println("- "+title);
		}
		
		Set<String> gradeMelon = new TreeSet();
		gradeMelon.addAll(melon);
		gradeMelon.removeAll(youtube);
		System.out.println("멜론 단일 순위권인 곡");
		for(String title:gradeMelon){
			System.out.println("- "+title);
		}
		
		
		//2.유투브 뮤직 또는 멜론 한 군데서만 순위권인 곡을 출력하세요
		Set<String> only = new TreeSet();
		only.addAll(melon);
		only.addAll(youtube);
		only.removeAll(gradeAll);
		System.out.println("한쪽에만 순위권인 곡");
		for(String title:only){
			System.out.println("- "+title);
		}
	}
}
