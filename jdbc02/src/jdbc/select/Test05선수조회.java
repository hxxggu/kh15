package jdbc.select;

import java.util.List;

import jdbc.dao.PlayerDao;
import jdbc.dto.PlayerDto;

public class Test05선수조회 {

	public static void main(String[] args) {
		PlayerDao playerDao = new PlayerDao();
		List<PlayerDto> list = playerDao.selectList();
		
		for(PlayerDto playerDto : list) {
			System.out.print("["+playerDto.getPlayerNo()+"]");
			System.out.print(playerDto.getPlayerName());
			System.out.print("/"+playerDto.getPlayerEvent());
			System.out.print("("+playerDto.getPlayerType()+")");
			System.out.print(" 금:"+playerDto.getPlayerGoldMedal());
			System.out.print(" 은:"+playerDto.getPlayerSilverMedal());
			System.out.println(" 동:"+playerDto.getPlayerBronzeMedal());
		}

	}

}
