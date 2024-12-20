package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test08포커게임3 {
	public static void main(String[] args) {
		
		//카드 덱 준비
		List<String> cardDeck = createCardDeck();
		
		//카드 덱 섞기
		Collections.shuffle(cardDeck);
		
		//System.out.println("덱 크기 : " + cardDeck.size());
		//System.out.println(cardDeck);
		
		//플레이어 준비(n명)
		List<List<String>> players = new ArrayList<>();
		
		players.add(new ArrayList<>());//index : 0
		players.add(new ArrayList<>());//index : 1
		players.add(new ArrayList<>());//index : 2
		players.add(new ArrayList<>());//index : 3
		
		for(int turn=1; turn <= 6; turn++) {//6턴 동안
			players.get(0).add(cardDeck.remove(0));//카드덱에서 꺼내 플레이어1에게 전달
			players.get(1).add(cardDeck.remove(0));//카드덱에서 꺼내 플레이어2에게 전달
			players.get(2).add(cardDeck.remove(0));//카드덱에서 꺼내 플레이어3에게 전달
			players.get(3).add(cardDeck.remove(0));//카드덱에서 꺼내 플레이어4에게 전달
		}
		
		System.out.println("player = " + players.get(0));
		System.out.println("player = " + players.get(1));
		System.out.println("player = " + players.get(2));
		System.out.println("player = " + players.get(3));
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