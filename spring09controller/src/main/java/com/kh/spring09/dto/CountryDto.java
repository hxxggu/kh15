package com.kh.spring09.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter @Getter //해당 클래스의 모든 필드값에 setter/getter를 만들어라
//@NoArgsConstructor //기본생성자
//@ToString
@Data
public class CountryDto {
	private int countryNo;
	private String countryName;
	private String countryCapital;
	private long countryPopulation;
}
