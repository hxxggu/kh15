package com.kh.spring12.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
// @Builder 어노테이션을 사용하는 위치를 모르겠다면 일단 쓰는 것을 추천
// 구현할 때 왜 쓰는지만 이해하면 됨
public class BuyDto {
	private long buyNo;
	private String buyOwner;
	private String buyName;
	private String buyTid;
	private long buyTotal;
	private long buyRemain;
	private Timestamp buyTime;
}
