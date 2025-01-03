package jdbc.select;

import java.util.List;

import jdbc.dao.GameUserDao;
import jdbc.dto.GameUserDto;

public class Test04게임유저조회 {

	public static void main(String[] args) {
		GameUserDao gameUserDao = new GameUserDao();
		List<GameUserDto> list = gameUserDao.selectList();
		
		for(GameUserDto gameUserDto : list) {
			System.out.print("["+gameUserDto.getGameUserNo()+"]");
			System.out.print(" ID:"+gameUserDto.getGameUserId());
			System.out.print(" / 직업:"+gameUserDto.getGameUserJob());
			System.out.print(" / Level "+gameUserDto.getGameUserLevel());
			System.out.println(" / 소지금:"+gameUserDto.getGameUserMoney());
		}

	}

}
