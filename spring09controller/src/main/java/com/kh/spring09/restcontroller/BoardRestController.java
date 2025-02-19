package com.kh.spring09.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.BoardDao;

import jakarta.servlet.http.HttpSession;

//@CrossOrigin
@RestController
@RequestMapping("/rest/board")
public class BoardRestController {
	
	@Autowired
	private BoardDao boardDao;
	
	// 좋아요 여부 검사 매핑
	@RequestMapping("/check")
	public Map<String, Object> check(
			@RequestParam int boardNo,
			HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		
		boolean done = boardDao.checkBoardLike(userId, boardNo);
		// 내가 좋아요를 눌렀는지 누르지 않았는지 확인 가능
		int cnt = boardDao.cntBoardLike(boardNo);
		
		Map<String, Object> map = new HashMap<>();
		map.put("done", done); // 해당 회원의 좋아요 여부
		map.put("cnt", cnt); // 해당 글의 좋아요 여부
		return map;
	}
	
	// 좋아요 설정 / 해제 매핑
	@RequestMapping("/action")
	public Map<String, Object> action(
			@RequestParam int boardNo, HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		boolean done = boardDao.checkBoardLike(userId, boardNo);
		if(done) { // 이미 좋아요 한 상태
			boardDao.deleteBoardLike(userId, boardNo); // 삭제
		} else { // 좋아요 한 적 없는 상태
			boardDao.insertBoardLike(userId, boardNo); // 등록
		}
		
		int cnt = boardDao.cntBoardLike(boardNo); // 카운트 다시 구하기
		
		Map<String, Object> map = new HashMap<>(); 
		map.put("done", !done); // 이 회원의 좋아요 여부
		map.put("cnt", cnt); // 이 글의 좋아요 개수
		return map;
	}
	
}
