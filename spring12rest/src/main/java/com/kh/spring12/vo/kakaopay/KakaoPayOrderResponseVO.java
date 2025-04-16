package com.kh.spring12.vo.kakaopay;import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoPayOrderResponseVO {
	
	private String tid; // 결제 고유 번호
	private String cid; // 가맹점 코드
	private String status; // 결제 상태
	private String partnerOrderId; // 가맹점 주문번호
	private String partnerUserId; // 가맹점 회원 ID
	
	private KakaoPayAmountVO amount; // 결제 금액
	private KakaoPayAmountVO canceledAmont; // 취소된 금액
	private KakaoPayAmountVO canceledAvailableAmount; // 취소 가능 금액
	
	private String itemName; // 상품 이름
	private String itemCode; // 상품 코드
	private int quantity; // 상품 수량
	private LocalDateTime createAt; // 결제 준비 시각
	private LocalDateTime approveAt; // 결제 승인 시각
	private LocalDateTime canceledAt; // 결제 취소 시각
	private kakaoPaySelectedCardInfoVO selectedCardInfo; // 결제 카드 정보
	
	// private KakaoPayPaymentActionDetails[] paymentActionDetails;
	private List<KakaoPayPaymentActionDetailsVO> paymentActionDetails; // 결제/취소 상세
}
