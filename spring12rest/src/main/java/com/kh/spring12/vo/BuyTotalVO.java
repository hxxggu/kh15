package com.kh.spring12.vo;

import java.util.List;

import com.kh.spring12.dto.BuyDetailDto;
import com.kh.spring12.dto.BuyDto;

import lombok.Data;

// 한 건의 결제에 대한 모든 정보가 다 담긴 클래스
@Data
// 자동으로 생성되므로 builder는 어노테이션에 추가하지 않음
public class BuyTotalVO {
	private BuyDto buyDto; // 결제 대표 정보
	private List<BuyDetailDto> buyList; // 결제 상세 목록
	// javaType : List
}
