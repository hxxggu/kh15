package jdbc.select3;

import jdbc.dao.PlayerDao;
import jdbc.dto.PlayerDto;

public class Test05선수상세 {

	public static void main(String[] args) {
		int playerNo = 3;
		
		PlayerDao playerDao = new PlayerDao();
		PlayerDto playerDto = playerDao.selectOne(playerNo);
		
		if(playerDto != null) {
			System.out.print("["+playerDto.getPlayerNo()+"]");
			System.out.print(playerDto.getPlayerName());
			System.out.print("/"+playerDto.getPlayerEvent());
			System.out.print("("+playerDto.getPlayerType()+")");
			System.out.print(" 금:"+playerDto.getPlayerGoldMedal());
			System.out.print(" 은:"+playerDto.getPlayerSilverMedal());
			System.out.println(" 동:"+playerDto.getPlayerBronzeMedal());
		} else System.out.println("존재하지 않는 선수 번호");
	}

}
