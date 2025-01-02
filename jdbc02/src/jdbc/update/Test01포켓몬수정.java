package jdbc.update;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcFactory;

public class Test01포켓몬수정 {

	public static void main(String[] args) {
		//목표 : 포켓몬스터 정보를 변경하는 코드 작성 (main에 전부 작성)
		//*JDBC는 구문이 정해져야 한다
		
		
		//입력
		int pokemonNo = 10;
		String pokemonName = "바꾼이름";
		String pokemonType = "바람";
				
		//처리
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "update pokemon "
				+"set pokemon_name = ?, pokemon_type =? "
				+"where pokemon_no = ?";
		
		Object[] data = {
				pokemonName, pokemonType, pokemonNo
		};
		int rows = jdbcTemplate.update(sql, data);
		System.out.println("rows = " + rows);
				
		//출력
		if(rows > 0) {
			System.out.println("수정완료");
		} else {
			System.out.println("대상이 없습니다");
		}
		
		
	}

}
