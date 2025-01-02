package jdbc.delete;

import jdbc.dao.GameUserDao;

public class Test04게임유저삭제 {
	public static void main(String[] args) {
		
		int gameUserNo = 20;
		
		GameUserDao gameUserDao = new GameUserDao();
		boolean success = gameUserDao.delete(gameUserNo);
		
		if(success) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("존재하지 않는 게임 유저 번호");
		}
	}
}
