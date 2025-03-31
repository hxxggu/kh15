package com.kh.spring12;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test04마이바티스수정 {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void edit() {
		
	}

}
