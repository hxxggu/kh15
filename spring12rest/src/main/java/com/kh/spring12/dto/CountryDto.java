package com.kh.spring12.dto;

import lombok.Data;

@Data
public class CountryDto {
	private long countryNo;
	private String countryName;
	private String countryCapital;
	private long countryPopulation;
}