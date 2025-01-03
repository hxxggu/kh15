package jdbc.select3;

import jdbc.dao.PokemonDao;
import jdbc.dto.PokemonDto;

public class Test01포켓몬상세2 {

	public static void main(String[] args) {
		
		//상세조회
		
		int pokemonNo = 1;

		PokemonDao pokemonDao = new PokemonDao();
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		
		if(pokemonDto == null) {
			System.out.println("존재하지 않는 포켓몬 번호");
		} else {
			System.out.println(pokemonDto);
		}	
	}
}
