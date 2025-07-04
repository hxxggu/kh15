package com.kh.spring12.vo.kakaopay;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

// 카카오에서 승인 요청이 성공했을 때 돌려줄 정보를 저장할 VO
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaoPayApproveResponseVO {
	private String aid; // 요청 고유 번호
	private String tid; // 거래 고유 번호
	private String cid; // 가맹점 코드
	private String sid; // 정기결제용 코드
	private String partnerOrderId; // 주문번호
	private String partnerUserId; // 주문자
	private String paymentMethodType; // Card 또는 Money
	
	private KakaoPayAmountVO amount;
	private KakaoPayCardInfoVO cardInfo;
	
	private String itemName; // 결제 요청 이름
	private String itemCode; // 상품 코드
	private int quantity; //상품 수량
	private LocalDateTime createdAt; // 준비 시각
	private LocalDateTime approveAt; // 승인 시각
	private String payload; // 결제 시 추가한 텍스트
}
