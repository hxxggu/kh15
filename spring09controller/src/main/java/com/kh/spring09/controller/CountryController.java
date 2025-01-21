package com.kh.spring09.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09.dao.CountryDao;
import com.kh.spring09.dto.CountryDto;
import com.kh.spring09.service.AttachmentService;

@Controller
@RequestMapping("/country")
public class CountryController {
	@Autowired
	private CountryDao countryDao;
	@Autowired
	private AttachmentService attachmentService;
		
	//등록 매핑 - 3개
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/country/add.jsp";
	}
	//파일 첨부 기능 삽입 이전 코드
//	@PostMapping("/add")
//	public String add(@ModelAttribute CountryDto countryDto) {
//		countryDao.insert(countryDto);
//		return "redirect:addFinish";//상대경로
//		//return "redirect:/country/addFinish";//절대경로
//	}
	
	@PostMapping("/add")
	public String add(
			@ModelAttribute CountryDto countryDto,
			@RequestParam MultipartFile attach
			) throws IllegalStateException, IOException {
		int countryNo = countryDao.sequence();
		countryDto.setCountryNo(countryNo);
		countryDao.insert2(countryDto);
		
		if(attach.isEmpty() == false) { //첨부파일이 있으면
			int attachmentNo = attachmentService.save(attach); //파일 저장 및 DB 저장 둘다 처리 가능
			countryDao.connect(countryNo, attachmentNo);
		}
		return "redirect:addFinish";
	}
	
	@RequestMapping("/addFinish")
	public String addFinish() {
		return "/WEB-INF/views/country/addFinish.jsp";
	}
	
	//목록+검색 매핑
	@RequestMapping("/list")
	public String list(
			@RequestParam(required=false) String column,
			@RequestParam(required=false) String keyword,
			Model model) {
		boolean search = column!=null && keyword!=null;
		List<CountryDto> list;
		if(search) {
			list = countryDao.selectList(column, keyword);
		} else {
			list = countryDao.selectList();
		}
		
		model.addAttribute("search", search);
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/country/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int countryNo, Model model) {
		CountryDto countryDto = countryDao.selectOne(countryNo);
		model.addAttribute("countryDto", countryDto);
		return "/WEB-INF/views/country/detail.jsp";
	}
	
	//삭제 매핑
	@RequestMapping("/delete")
	public String delete(@RequestParam int countryNo) {
		try {
			int attachmentNo = countryDao.findAttachment(countryNo);
			attachmentService.delete(attachmentNo);
		} catch(Exception e) {}
		countryDao.delete(countryNo);
		return "redirect:list"; //redirect : 주소가 바뀜, 끝나고 다른 곳으로 이동(다른 주소로 보냄), 잦지 않은 특별한 작업(따로 표시를 해주야 함)
//		return "/WEB-INF/views/country /list.jsp"; //forward : 주소가 유지되고 화면만 연결, 보통의 일반적인 작업
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int countryNo, Model model) {
		CountryDto countryDto = countryDao.selectOne(countryNo);
		model.addAttribute("countryDto", countryDto);
		return "/WEB-INF/views/country/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(
			@ModelAttribute CountryDto countryDto,
			@RequestParam MultipartFile attach
			) throws IllegalStateException, IOException {
		boolean success = countryDao.update(countryDto);
		if(!success) return "redirect:list";
		if(success) {
			if(attach.isEmpty() == false) {
				try { //기존 이미지 삭제 처리
					int attachmentNo = countryDao.findAttachment(countryDto.getCountryNo());
					attachmentService.delete(attachmentNo);
				} catch(Exception e) {}
				int newAttachmentNo = attachmentService.save(attach);
				countryDao.connect(countryDto.getCountryNo(), newAttachmentNo);
			}
		}
		if(success) {
			return "redirect:detail?countryNo=" + countryDto.getCountryNo();
		} else {
		return "redirect:list";
		}
	}
}