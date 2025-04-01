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
 		// 암호화 코드
 		String encrypt = encoder.encode(accountDto.getAccountPw());
 		accountDto.setAccountPw(encrypt);
 		sqlSession.insert("account.join", accountDto);
	}
	
	public AccountDto selectOne(String accountId) {
		return sqlSession.selectOne("account.find", accountId);
	}
	
	public AccountDto selectOne(AccountDto accountDto) {
		return sqlSession.selectOne("account.find", accountDto);
	}
	
	public AccountDto login(AccountDto accountDto) { // controller 끼리는 호출 X
//		AccountDto findDto = sqlSession.selectOne("account.find", accountDto);
		AccountDto findDto = selectOne(accountDto); // 위-아래 같은 기능
		if(findDto == null) return null; // false를 대체함
		boolean isValid = encoder.matches(accountDto.getAccountPw(), findDto.getAccountPw());
		return isValid ? findDto : null;
	}
	
}