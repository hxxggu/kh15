package api.util.collection;

import java.util.ArrayList;
import java.util.List;

public class Test08포커게임 {
	public static void main(String[] args) {
		
		//카드 덱 준비
		List<String> shapes = List.of("다이아", "하트", "클로버", "스페이드");
		List<String> numbers = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
		
		List<String> cardDeck = new ArrayList<>();
		for(String shape : shapes) {
			for(String number : numbers) {
				//System.out.println("shape = " + shape+", number = " + number);
				cardDeck.add(shape + " " + number);
			}
		}
		System.out.println("덱 크기 : " + cardDeck.size());
		System.out.println(cardDeck);
		
	}
}