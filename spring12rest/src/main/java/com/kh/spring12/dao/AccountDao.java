package com.kh.spring12.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.AccountDto;

@Repository
public class AccountDao {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private PasswordEncoder encoder;
	
	public void insert(AccountDto accountDto) {
 		//암호화 코드
 		String encrypt = encoder.encode(accountDto.getAccountPw());
 		accountDto.setAccountPw(encrypt);
 		sqlSession.insert("account.join", accountDto);
	}
}