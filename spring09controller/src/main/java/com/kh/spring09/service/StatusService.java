package com.kh.spring09.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring09.dao.StatusDao;

@Service
public class StatusService {
	
	@Autowired
	private StatusDao statusDao;

}
