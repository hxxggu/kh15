package com.kh.spring12.dto;

import lombok.Data;

@Data
public class GameUserDto {
	private int gameUserNo;
	private String gameUserId;
	private String gameUserJob;
	private int gameUserLevel;
	private int gameUserMoney;
}