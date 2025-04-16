package com.kh.spring12.vo.kakaopay;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown =  true)
public class KakaoPayCancelResponseVO {
	private String aid; // 요청 고유 번호
	private String tid; // 거래 번호
	private String cid; // 가맹점 코드
	private String status; // 결제 상태
	private String partnerOrderId; // 주문 번호
	private String partnerUserId; // 주문자
	private String paymentMethodType; // Card 또는 Money
	private KakaoPayAmountVO amount; // 결제 금액
	private KakaoPayAmountVO approvedCancelAmount; // 이번에 취소된 금액
	private KakaoPayAmountVO  canceledAmount; // 누적 취소 금액
	private KakaoPayAmountVO cancelAvailableAmount; // 취소 가능 금액
	private String itemName; // 상품명
	private String itemCode; // 상품 코드
	private Integer quantity; // 상품 수량 (1로 고정)
	private LocalDateTime createdAt; //결제 시작 시간
	private LocalDateTime  approveAt; // 결제 승인 시각
	private LocalDateTime canceledAt; // 결제 취소 시각
	private String payload; // 결제 취소 요청시 추가 전달한 텍스트
}
