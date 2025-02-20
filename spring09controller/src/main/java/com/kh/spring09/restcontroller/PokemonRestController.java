package com.kh.spring09.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.PokemonDao;

import jakarta.servlet.http.HttpSession;

//@CrossOrigin
@RestController
@RequestMapping("/rest/pokemon")
public class PokemonRestController {
	@Autowired
	private PokemonDao pokemonDao;
	
	@RequestMapping("/check")
	public Map<String, Object> check(
			@RequestParam int pokemonNo,
			HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		
		boolean done = pokemonDao.checkPokemonLike(userId, pokemonNo);
		// 내가 좋아요를 눌렀는지 누르지 않았는지 확인 가능
		int count = pokemonDao.countPokemonLike(pokemonNo);
		
		Map<String, Object> map = new HashMap<>();
		map.put("done", done); // 해당 회원의 좋아요 여부
		map.put("count", count); // 해당 글의 좋아요 여부
		return map;
	}
	
	// 좋아요 설정 / 해제 매핑 → 게시글의 좋아요 개수를 갱신
	@RequestMapping("/action")
	public Map<String, Object> action(
			@RequestParam int pokemonNo, HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		boolean done = pokemonDao.checkPokemonLike(userId, pokemonNo);
		if(done) { // 이미 좋아요 한 상태
			pokemonDao.deletePokemonLike(userId, pokemonNo); // 삭제
		} else { // 좋아요 한 적 없는 상태
			pokemonDao.insertPokemonLike(userId, pokemonNo); // 등록
		}
		
		int count = pokemonDao.countPokemonLike(pokemonNo); // 카운트 다시 구하기
		pokemonDao.updatePokemonLike(pokemonNo, count); // 좋아요 개수 갱신
		// pokemonDao.updatePokemonLike(pokemonNo); // 좋아요 개수 갱신
		
		Map<String, Object> map = new HashMap<>(); 
		map.put("done", !done); // 이 회원의 좋아요 여부
		map.put("count", count); // 이 글의 좋아요 개수
		return map;

	}
}
