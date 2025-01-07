package com.kh.spring05.dto;

//등록은 왜 하는 걸까?
//: 인스턴스를 직접 생성하지 않고 스프링에게 생성을 요청하는 것
//: 특별한 옵션이 없다면 1개만 생성(싱글톤, singleton)
//: DTO는 여러 개 존재하며 필요할 때마다 만들어야 한다
//: 등록을 하지 않고 그때그때 new로 만들어서 사용
public class PokemonDto {
	private int pokemonNo;
	private String PokemonName;
	private String PokemonType;
	
	public int getPokemonNo() {
		return pokemonNo;
	}
	public void setPokemonNo(int pokemonNo) {
		this.pokemonNo = pokemonNo;
	}
	public String getPokemonName() {
		return PokemonName;
	}
	public void setPokemonName(String pokemonName) {
		PokemonName = pokemonName;
	}
	public String getPokemonType() {
		return PokemonType;
	}
	public void setPokemonType(String pokemonType) {
		PokemonType = pokemonType;
	}
	
	public PokemonDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "PokemonDto [pokemonNo=" + pokemonNo + ", PokemonName=" + PokemonName + ", PokemonType=" + PokemonType
				+ "]";
	}
}
