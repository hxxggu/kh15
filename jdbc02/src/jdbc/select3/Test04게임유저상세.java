package jdbc.select3;

import jdbc.dao.GameUserDao;
import jdbc.dto.GameUserDto;

public class Test04게임유저상세 {

	public static void main(String[] args) {
		int gameUserNo = 8;
		
		GameUserDao gameUserDao = new GameUserDao();
		GameUserDto gameUserDto = gameUserDao.selectOne(gameUserNo);
		
		if(gameUserDto != null) {
			System.out.print("["+gameUserDto.getGameUserNo()+"]");
			System.out.print(" ID:"+gameUserDto.getGameUserId());
			System.out.print(" / 직업:"+gameUserDto.getGameUserJob());
			System.out.print(" / Level "+gameUserDto.getGameUserLevel());
			System.out.println(" / 소지금:"+gameUserDto.getGameUserMoney());
		} else System.out.println("존재하지 않는 유저 번호");

	}

}
