package com.kh.spring12.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class GiftcardDto {
	private int giftcardNo; //상품권 번호
	private String  giftcardName; //상품권 제목
	private String giftcardContent; //상품권 설명
	private int giftcardCharge; //충전 포인트
	private int giftcardPrice; //판매가
	
	public int getDiscountRate() {	
	    try {
	        return (giftcardPrice - giftcardCharge) / giftcardPrice * 100;
	    } catch (ArithmeticException e) {
	        // 예외 발생 시 기본값 0 반환
	        return 0;
	    }
	}
}
