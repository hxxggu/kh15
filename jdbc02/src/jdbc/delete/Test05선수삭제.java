package jdbc.delete;

import jdbc.dao.PlayerDao;

public class Test05선수삭제 {
	public static void main(String[] args) {
		
		int playerNo = 22;
		
		PlayerDao playerDao = new PlayerDao();
		boolean success = playerDao.delete(playerNo);
		
		if(success) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("존재하지 않는 선수 번호");
		}
	}
}
