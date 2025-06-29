package com.kh.spring12.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ItemDto {
	private Long itemNo;
	private String itemName;
	private String itemType;
	private Integer itemPrice;
	private Float itemDiscountRate;
	private Integer itemQty;
	private String itemEarly;
	
	public int getRealPrice() {
		if(itemPrice == null) return 0;
		if(itemDiscountRate == null) return itemPrice;
		return (int) (itemPrice * (1 - itemDiscountRate));
	}
}
