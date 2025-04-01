package com.kh.spring12.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.AccountDao;
import com.kh.spring12.dto.AccountDto;

@CrossOrigin
@RestController
@RequestMapping("/api/account")
public class AccountRestController {
	@Autowired
	private AccountDao accountDao;
	
	@PostMapping("/")
	public void join(@RequestBody AccountDto accountDto) {
		accountDao.insert(accountDto);
	}
}
