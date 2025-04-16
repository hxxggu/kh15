package com.kh.spring12.kakaopay;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.dao.BuyDao;
import com.kh.spring12.dto.BuyDetailDto;
import com.kh.spring12.dto.BuyDto;
import com.kh.spring12.vo.BuyTotalVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test04계층형조회 {
	
	@Autowired
	private BuyDao buyDao;
	
	@Test
	public void test() {
		// List<BuyTotalVO> 형태로 데이터를 꽉 채워서 조회
		// - 한번에 하는 것은 불가능 → 부분 작업으로 진행
		// - [1] BuyDto의 목록을 조회
		// - [2] 각각의 BuyDto에 대한 BuyDetailDto 목록을 조회 (반복문)
		// - [3] BuyTotalVO 형태로 포장해서 리스트 담기
		List<BuyTotalVO> results = new ArrayList<>();
			
		List<BuyDto> list = buyDao.listBuy(); // [1] 
		for(BuyDto buyDto : list) { // [2]
			List<BuyDetailDto> details = buyDao.listBuyDetail(buyDto.getBuyNo()); // 번호를 알려줄테니 정보를 넣어라
			
			BuyTotalVO vo= new BuyTotalVO(); // [3]
			vo.setBuyDto(buyDto);
			vo.setBuyList(details);
				
			results.add(vo);
		}
	}
}
