package jdbc.delete;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcFactory;

public class Test01포켓몬삭제 {

	public static void main(String[] args) {
		//목표 : 원하는 번호(PK)의 포켓몬 정보를 삭제
		
		int pokemonNo = 777;
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "delete pokemon where pokemon_no = ?";
		Object[] data = {pokemonNo};
		int rows = jdbcTemplate.update(sql, data);
		
		if(rows == 1) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("존재하지 않는 포켓몬 번호");
		}
	}
}
