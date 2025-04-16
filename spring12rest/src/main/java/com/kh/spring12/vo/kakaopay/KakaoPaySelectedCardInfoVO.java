package com.kh.spring12.vo.kakaopay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoPaySelectedCardInfoVO {
	private String cardBin; // 카드BIN
	private Integer installMonth; // 할부 개월 수
	private String installmentType; // 할부 유형
	private String cardCoprName; // 카드사 정보
	private String interestFreeInstall; // 무이자 할부 여부 (Y/N)
}
