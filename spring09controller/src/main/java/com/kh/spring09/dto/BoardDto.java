package com.kh.spring09.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class BoardDto {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private Timestamp boardWtime, boardEtime;
	private int boardLike, boardRead, boardReply;
	
	//날짜를 출력하기 위한 가상의 메소드
	//- boardWtime과 현재날짜를 비교
	public String getBoardWtimeString() {
		LocalDate today = LocalDate.now();
		LocalDateTime wtime = boardWtime.toLocalDateTime();
		//wtime의 날짜와 today를 비교하여 어떤 값을 내보낼지 결정
		LocalDate wdate = wtime.toLocalDate();
		
//		if(today.isAfter(wdate)) {
		if(wdate.isBefore(today)) {
			return wdate.toString();
		}
		else {
			return wtime.toLocalTime()
						.format(DateTimeFormatter.ofPattern("HH:mm"));
		}
	}
}
