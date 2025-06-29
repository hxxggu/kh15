package com.kh.spring10.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberDto {
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
}
