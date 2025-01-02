package jdbc.insert2;

public class Test07게임유저등록 {
	public static void main(String[] args) {
		
		GameUserDto gameUserDto = new GameUserDto();
		gameUserDto.setGameUserId("테스트유저");
		gameUserDto.setGameUserJob("성직자");
		gameUserDto.setGameUserLevel(50);
		gameUserDto.setGameUserMoney(0);
		
		GameUserDao gameUserDao = new GameUserDao();
		gameUserDao.insert(gameUserDto);
		
		System.out.println("등록 완료");
		
	}
}