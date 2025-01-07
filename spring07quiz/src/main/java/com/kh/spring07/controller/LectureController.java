package com.kh.spring07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring07.dao.LectureDao;
import com.kh.spring07.dto.LectureDto;

@RestController
@RequestMapping("/lecture")
public class LectureController {
	@Autowired
	private LectureDao lectureDao;
	
	@RequestMapping("/add") //등록
	public String insert(@ModelAttribute LectureDto lectureDto) {
		lectureDao.insert(lectureDto);
		return "강의 정보 등록 완료";
	}
	
	@RequestMapping("/list") //목록+검색
	public String list(
			@RequestParam(required=false) String column,
			@RequestParam(required=false) String keyword) {
		boolean search = column!=null && keyword!=null;
		List<LectureDto> list = search ? 
				lectureDao.selectList(column, keyword) : lectureDao.selectList();
		StringBuffer bf = new StringBuffer();
		if(list.isEmpty()) bf.append("데이터가 존재하지 않습니다");
		else {
			bf.append("데이터 개수 : " + list.size() + "<br>");
			for(LectureDto lectureDto : list) {
				bf.append(lectureDto.toString());
				bf.append("<br>");
			}
		} return bf.toString();
	}
	
	@RequestMapping("/detail") //상세
	public String detail(@RequestParam int lectureNo) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) return "존재하지 않는 강의 번호";
		else return lectureDto.toString();
	}
	
	@RequestMapping("/edit") //수정
	public String edit(@ModelAttribute LectureDto lectureDto) {
		boolean success = lectureDao.update(lectureDto);
		return success ? "강의 정보 수정 완료" : "존재하지 않는 강의 번호";
	}
	
	@RequestMapping("/delete") //삭제
	public String delete(@ModelAttribute LectureDto lectureDto) {
		boolean success = lectureDao.update(lectureDto);
		return success ? "강의 정보 삭제 완료" : "존재하지 않는 강의 번호";
	}
}
