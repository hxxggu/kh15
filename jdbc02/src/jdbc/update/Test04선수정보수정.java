package jdbc.update;

import jdbc.dao.PlayerDao;
import jdbc.dto.PlayerDto;

public class Test04선수정보수정 {
	public static void main(String[] args) {
		
		//선수 정보 수정
		PlayerDto playerDto = new PlayerDto();
		playerDto.setPlayerNo(50);
		playerDto.setPlayerName("전종오");
		playerDto.setPlayerEvent("사격");
		playerDto.setPlayerType("하계");
		playerDto.setPlayerGoldMedal(1);
		playerDto.setPlayerSilverMedal(2);
		playerDto.setPlayerBronzeMedal(3);
		
		//정보설정
		PlayerDao playerDao = new PlayerDao();
		boolean success = playerDao.update(playerDto);
		
		if(success) System.out.println("선수 정보 변경 완료");
		else System.out.println("대상이 없습니다");
		
		
	}
}
