package com.kh.spring09.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDto {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private Timestamp boardWtime;
	private Timestamp boardEtime;
	private long boardLike;
	private long boardRead;
	private long boardReply;
}