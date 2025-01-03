package jdbc.select2;

import java.util.List;

import jdbc.dao.GameUserDao;
import jdbc.dto.GameUserDto;

public class Test04게임유저검색 {

	public static void main(String[] args) {
		
		String column = "아이디"; //아이디, 직업, 레벨
		String keyword = "sita0628";
		
		GameUserDao gameUserDao = new GameUserDao();
		List<GameUserDto> list = gameUserDao.selectList(column, keyword);
		
		for(GameUserDto gameUserDto : list) {
			System.out.print("["+gameUserDto.getGameUserNo()+"]");
			System.out.print(" ID:"+gameUserDto.getGameUserId());
			System.out.print(" / 직업:"+gameUserDto.getGameUserJob());
			System.out.print(" / Level "+gameUserDto.getGameUserLevel());
			System.out.println(" / 소지금:"+gameUserDto.getGameUserMoney());
		}
	}

}
