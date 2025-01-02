package jdbc.update;

import jdbc.dao.PokemonDao;
import jdbc.dto.PokemonDto;

public class Test01포켓몬수정2 {

	public static void main(String[] args) {
		//목표 : 포켓몬스터 정보를 변경하는 코드 작성 (main에 전부 작성)
		//*JDBC는 구문이 정해져야 한다
				
		//입력
		PokemonDto pokemonDto = new PokemonDto();
		pokemonDto.setPokemonNo(1);
		pokemonDto.setPokemonName("바꾼이름");
		pokemonDto.setPokemonType("바람");
				
		//처리
		PokemonDao pokemonDao = new PokemonDao();
		boolean success = pokemonDao.update(pokemonDto);
		
		//출력
		if(success) {
			System.out.println("수정완료");
		} else {
			System.out.println("대상이 없습니다");
		}
		
	}

}
