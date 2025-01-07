package com.kh.spring07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring07.dao.ItemDao;
import com.kh.spring07.dto.ItemDto;
import com.kh.spring07.dto.PlayerDto;


@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemDao itemDao;
	
	@RequestMapping("/add") //등록
	public String insert(@ModelAttribute ItemDto itemDto) {
		itemDao.insert(itemDto);
		return "상품 정보 등록 완료";
	}
	
	@RequestMapping("/list") //목록+검색
	public String list(
			@RequestParam(required=false) String column,
			@RequestParam(required=false) String keyword) {
		boolean search = column!=null && keyword!=null;
		List<ItemDto> list = search ? 
				itemDao.selectList(column, keyword) : itemDao.selectList();
		StringBuffer bf = new StringBuffer();
		if(list.isEmpty()) bf.append("데이터가 존재하지 않습니다");
		else {
			bf.append("데이터 개수 : " + list.size() + "<br>");
			for(ItemDto itemDto : list) {
				bf.append(itemDto.toString());
				bf.append("<br>");
			}
		} return bf.toString();
	}
	
	@RequestMapping("/detail") //상세
	public String detail(@RequestParam int itemNo) {
		ItemDto itemDto = itemDao.selectOne(itemNo);
		if(itemDto == null) return "존재하지 않는 상품 번호";
		else return itemDto.toString();
	}
	
	@RequestMapping("/edit") //수정
	public String edit(@ModelAttribute ItemDto itemDto) {
		boolean success = itemDao.update(itemDto);
		return success ? "상품 정보 수정 완료" : "존재하지 않는 상품 번호";
	}
	
	@RequestMapping("/delete") //삭제
	public String delete(@ModelAttribute ItemDto itemDto) {
		boolean success = itemDao.update(itemDto);
		return success ? "상품 정보 삭제 완료" : "존재하지 않는 상품 번호";
	}
}

