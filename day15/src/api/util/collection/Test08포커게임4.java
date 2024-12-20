package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test08포커게임4 {
	public static void main(String[] args) {
		
		//카드 덱 준비
		List<String> cardDeck = createCardDeck();
		
		//카드 덱 섞기
		Collections.shuffle(cardDeck);
		
		//System.out.println("덱 크기 : " + cardDeck.size());
		//System.out.println(cardDeck);
		
		//플레이어 준비(n명)
		int people = 4;
		List<List<String>> players = new ArrayList<>();
		for(int i=0; i < people; i++) {
			players.add(new ArrayList<>());
		}
		
		for(int turn=1; turn <= 6; turn++) {//6턴 동안
			for(int i=0; i < people; i++) {
				players.get(i).add(cardDeck.remove(0));
			}
		}

		for(int i=0; i < people; i++) {
			System.out.println("player = " + players.get(i));
		}
	}
	
	//카드 덱 생성 명령
	public static List<String> createCardDeck() {
		List<String> shapes = List.of("다이아", "하트", "클로버", "스페이드");
		List<String> numbers = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
		
		List<String> cardDeck = new ArrayList<>();
		for(String shape : shapes) {
			for(String number : numbers) {
				//System.out.println("shape = " + shape+", number = " + number);
				cardDeck.add(shape + " " + number);
			}
		}
		return cardDeck;
	}
}