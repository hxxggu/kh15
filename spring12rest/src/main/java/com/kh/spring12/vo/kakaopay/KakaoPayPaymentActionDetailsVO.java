package com.kh.spring12.vo.kakaopay;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoPayPaymentActionDetailsVO {
	private String aid; // 고유 번호
	private LocalDateTime approveAt; // 거래 시간
	private Integer amount; // 결제/취소 총액
	private Integer pointAmount; // 결제/취소 포인트 금액
	private Integer discountAmount; // 할인 금액
	private Integer greenDeposit; // 컵 보증금
	private String paymentActionType; // 결제 타입 (PAYMENT(결제), CANCEL(결제취소), ISSUED_SID(SID 발급) 중 하나)
	private String payload; // 추가 전달할 텍스트
}
