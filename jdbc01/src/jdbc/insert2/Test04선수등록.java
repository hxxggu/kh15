package jdbc.insert2;

public class Test04선수등록 {
	public static void main(String[] args) {
		
		PlayerDto playerDto = new PlayerDto();
		
		playerDto.setPlayerName("김연아");
		playerDto.setPlayerEvent("피겨스케이팅");
		playerDto.setPlayerType("하계");
		playerDto.setPlayerGoldMedal(7);
		playerDto.setPlayerSilverMedal(3);
		playerDto.setPlayerBronzeMedal(5);
		
		PlayerDao playerDao = new PlayerDao();
		playerDao.insert(playerDto);
		
		System.out.println("등록 완료");
	}
}
