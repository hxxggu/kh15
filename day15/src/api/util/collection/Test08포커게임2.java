package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test08포커게임2 {
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
		
		//카드 덱 섞기
		Collections.shuffle(cardDeck);
		
		//System.out.println("덱 크기 : " + cardDeck.size());
		//System.out.println(cardDeck);
		
		//플레이어 준비(4명)
		List<String> player1 = new ArrayList<>();
		List<String> player2 = new ArrayList<>();
		List<String> player3 = new ArrayList<>();
		List<String> player4 = new ArrayList<>();
		
		for(int turn=1; turn <= 6; turn++) {//6턴 동안
			player1.add(cardDeck.remove(0));//카드덱에서 꺼내 플레이어1에게 전달
			player2.add(cardDeck.remove(0));//카드덱에서 꺼내 플레이어2에게 전달
			player3.add(cardDeck.remove(0));//카드덱에서 꺼내 플레이어3에게 전달
			player4.add(cardDeck.remove(0));//카드덱에서 꺼내 플레이어4에게 전달
		}
		
		System.out.println("player1 = " + player1);
		System.out.println("player2 = " + player2);
		System.out.println("player3 = " + player3);
		System.out.println("player4 = " + player4);
	}
}