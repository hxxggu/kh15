package com.kh.spring12.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring12.configuration.TokenProperties;
import com.kh.spring12.dto.AccountDto;
import com.kh.spring12.vo.ClaimVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

// jWT 토큰을 발행하거나 해석하는 서비스
@Slf4j
@Service
public class TokenService {
	
	@Autowired
	private TokenProperties tokenProperties;
	
	public String generateAccessToken(AccountDto accountDto) { // test01
		
		// 만료 시간 계산
		Calendar  c = Calendar.getInstance();
		Date now = c.getTime(); // 현재 시각
		c.add(Calendar.MINUTE, tokenProperties.getExpireMinutes());
		Date limit = c.getTime(); // 만료 시각
		
		// 토큰에 들어갈 정보들을 DB에 저장하는 코드
		
		// 토큰 생성 (DB에 저장한 정보를 기반으로 생성)
		return Jwts.builder()
					.signWith(tokenProperties.getKey())
					.expiration(limit)
					.issuer(tokenProperties.getIssuer())
					.issuedAt(now)
					.claim("userId", accountDto.getAccountId())
					.claim("userLevel", accountDto.getAccountLevel())
				.compact();
	}
	
	public String generateRefreshToken(AccountDto accountDto) {
		
		// 시간 계산
		Calendar  c = Calendar.getInstance();
		Date now = c.getTime(); // 현재 시각
		c.add(Calendar.MINUTE, 2*7*24*60); // 2*7*24*60=2주 
		Date limit = c.getTime(); // 만료 시각
		
		// 토큰 생성
		return Jwts.builder()
					.signWith(tokenProperties.getKey())
					.expiration(limit)
					.issuer(tokenProperties.getIssuer())
					.issuedAt(now)
					.claim("userId", accountDto.getAccountId())
					.claim("userLevel", accountDto.getAccountLevel())
				.compact();
	}

	public ClaimVO parse(String token) { // test02
		
		Claims claims = (Claims) Jwts.parser() // claims로 다운캐스팅
				.verifyWith(tokenProperties.getKey())
				.requireIssuer(tokenProperties.getIssuer())
			.build()
				.parse(token)
				.getPayload();
		
		return ClaimVO.builder()
				.userId((String) claims.get("userId")) // 다운캐스팅
				.userLevel((String) claims.get("userLevel")) // 다운캐스팅
			.build();
	}
}
