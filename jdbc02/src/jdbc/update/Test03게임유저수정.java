package jdbc.update;

import jdbc.dao.GameUserDao;
import jdbc.dto.GameUserDto;

public class Test03게임유저수정 {
	public static void main(String[] args) {
		GameUserDto gameUserDto = new GameUserDto();
		gameUserDto.setGameUserNo(2);
		gameUserDto.setGameUserId("변경된아이디");
		gameUserDto.setGameUserJob("도적");
		gameUserDto.setGameUserLevel(4);
		gameUserDto.setGameUserMoney(3000);
		
		GameUserDao gameUserDao = new GameUserDao();
		boolean success = gameUserDao.update(gameUserDto);
		
		if(success) {
			System.out.println("수정완료");
		} else {
			System.out.println("대상이 없습니다");
		}
	}
}
