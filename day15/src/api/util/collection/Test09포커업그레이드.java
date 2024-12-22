package api.util.collection;
import java.util.ArrayList;
import java.util.List;
public class Test09포커업그레이드 {
	public static void main(String[] args) throws Exception {
		List<String> shapes = List.of("다이아", "하트", "클로버", "스페이드");
		List<String> numbers = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
		
		CardDeck deck = new CardDeck();//비어있는 카드덱을 생성
		for(String shape : shapes) {
			for(String number : numbers) {
				Card card = new Card(shape, number);//카드 생성
				deck.add(card);//카드덱에 카드 추가
			}
		}
		
		//카드 섞기
		deck.shuffle();
		
		//플레이어 생성
		List<Player> players = new ArrayList<>();
		
		players.add(new Player("피카츄"));
		players.add(new Player("라이츄"));
		players.add(new Player("파이리"));
		players.add(new Player("꼬부기"));
		
		for(int turn=1; turn <= 6; turn++) {
			players.get(0).receive(deck.draw());
			players.get(1).receive(deck.draw());
			players.get(2).receive(deck.draw());
			players.get(3).receive(deck.draw());
		}
		
		for(Player player : players) {
			System.out.println(player);
		}
	}
}