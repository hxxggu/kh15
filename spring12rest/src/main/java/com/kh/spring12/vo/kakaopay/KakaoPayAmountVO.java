package com.kh.spring12.vo.kakaopay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoPayAmountVO {
	private long total; // 결제 전체 금액
	private long taxFree; // 비과세 금액
	private long vat; // 부가세 금액
	private long point; // 사용한 포인트 금액
	private long discount; // 할인 금액
	private long greenDeposit; // 컵 보증금
}
