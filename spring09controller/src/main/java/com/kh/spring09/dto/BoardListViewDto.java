package com.kh.spring09.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

//oracle의 board_list_view와 연결될 DTO
@Data
public class BoardListViewDto {

	private int boardNo;
	private String boardTitle;
//	private String boardContent;
	private String boardWriter;
	private Timestamp boardWtime, boardEtime;
	private int boardLike, boardRead, boardReply;
	private int boardGroup;
	private Integer boardTarget;
	private int boardDepth;
	
	//상위글정보
	private int targetNo;
	private String targetTitle;
	
	private String memberId; //아이디
	private String memberPw; //비밀번호
	private String memberNickname; //닉네임
	private String memberBirth; //생년월일
	private String memberContact; //연락처
	private String memberEmail; //이메일
	private String memberLevel; //회원등급
	private int memberPoint; //보유 포인트
	private String memberPost; //우편번호
	private String memberAddress1; //기본주소
	private String memberAddress2;//상세주소
	private Timestamp memberJoin; //가입 일시
	private Timestamp memberLogin; //최종 로그인 일시
	private Timestamp memberChange; //최종 비밀번호 변경 일시

	public String getBoardWtimeString() {
		LocalDate today = LocalDate.now();
		LocalDateTime wtime = boardWtime.toLocalDateTime();
		LocalDate wdate = wtime.toLocalDate();
		if(wdate.isBefore(today)) {
			return wdate.toString();
		}
		else {
			return wtime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
		}
	}
}
