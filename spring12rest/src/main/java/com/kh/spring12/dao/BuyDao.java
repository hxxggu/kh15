package com.kh.spring12.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.BuyDetailDto;
import com.kh.spring12.dto.BuyDto;

@Repository
public class BuyDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public long addBuy(BuyDto buyDto) {
		long buyNo = sqlSession.selectOne("buy.buySequence");
		buyDto.setBuyNo(buyNo);
		sqlSession.insert("buy.addBuy", buyDto);
		return buyNo;
	}
	
	public long addBuyDetail(BuyDetailDto buyDetailDto) {
		long buyDetailNo = sqlSession.selectOne("buy.buyDetailSequence");
		buyDetailDto.setBuyDetailNo(buyDetailNo);
		sqlSession.insert("buy.addBuyDetail", buyDetailDto);
		return buyDetailNo;
	}
}
