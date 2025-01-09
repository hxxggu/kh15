package com.kh.spring08.dto;

import lombok.Data;

//등록은 왜 하는 걸까?
//: 인스턴스를 직접 생성하지 않고 스프링에게 생성을 요청하는 것
//: 특별한 옵션이 없다면 1개만 생성(싱글톤, singleton)
//: DTO는 여러 개 존재하며 필요할 때마다 만들어야 한다
//: 등록을 하지 않고 그때그때 new로 만들어서 사용
//@Setter @Getter @ToString @AllArgsConstructor
@Data
public class PokemonDto {
	private int pokemonNo;
	private String PokemonName;
	private String PokemonType;
	
}
