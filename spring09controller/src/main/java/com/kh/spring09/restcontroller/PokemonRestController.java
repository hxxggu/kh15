package com.kh.spring09.restcontroller;

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
	}
}
