package jdbc.select2;

import java.util.List;

import jdbc.dao.PokemonDao;
import jdbc.dto.PokemonDto;

public class Test01포켓몬검색4 {
	public static void main(String[] args) {
				
//		String column = "이름";
//		String keyword = "테스트";
		
		String column = "속성";
		String keyword = "바람";
		
		PokemonDao pokemonDao = new PokemonDao();
		List<PokemonDto> list = pokemonDao.selectList(column, keyword);
		
		for(PokemonDto pokemonDto : list) {
			System.out.print("[No."+pokemonDto.getPokemonNo()+"]");
			System.out.print(pokemonDto.getPokemonName());
			System.out.println("("+ pokemonDto.getPokemonType() +")");
		}
	}
}
