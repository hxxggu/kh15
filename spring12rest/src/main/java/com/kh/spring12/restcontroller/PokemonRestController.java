package com.kh.spring12.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.PokemonDao;
import com.kh.spring12.dto.PokemonDto;
import com.kh.spring12.error.TargetNotFoundException;
import com.kh.spring12.vo.SearchVO;

@CrossOrigin
@RestController
@RequestMapping("/api/pokemon")
public class PokemonRestController {
	@Autowired
	private PokemonDao pokemonDao;
	
	// @RequestMapping은 이제 사용하지 않는다
	// 작업에 맞게 주소를 최소화하여 사용한다 (자원 기반 주소 방식, ROA)
	// - 주소가 같아도 방식이 다르면 다른 작업을 시킬 수 있다
	// - 방식이 몇 가지가 있을까? 작업은 몇 종류가 있을까?
	// - 작업은 C, R, U, D 네 가지가 있다
	// - Get, Post, Put, Delete 방식을 각각의 작업에 연결하여 사용
	// - 조회(GET), 삭제(DELETE), 등록(POST), 수정(PUT-전체수정 / PATCH-부분수정)
	// - 주소에 기능은 가급적 배제하고 Entity 만 기술
	
	
	@GetMapping("/")
	public List<PokemonDto> list() {
		return pokemonDao.selectList();
	}
	
	@DeleteMapping("/{pokemonNo}")
	public void delete(@PathVariable int pokemonNo) {
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		if(pokemonDto == null) {
			throw new TargetNotFoundException();
		}
		pokemonDao.delete(pokemonNo);
	}
	
	// 이 방식에서 @ModelAttribute는 사용이 어렵다
	// JSON 으로 전달되는 데이터는 @RequestBody로 읽는다
	// (*주의) RequestBody가 두 개가 있는데, 잘 골라야 합니다 (Spring으로)
	@PostMapping("/")
	public void insert(@RequestBody PokemonDto pokemonDto) {
		pokemonDao.insert(pokemonDto);
	}
	
	// 컬럼 + 키워드 검색
	// - 항목(column), 검색어(keyword)를 전달받아서 검색하도록 구현
	// - 문제는 두 개의 데이터를 어떻게 받을 것인가?
	// [1] 조회니까 GET 방식으로 수신하며, 각각의 데이터는 경로변수로 수신
	// [2] 조회지만, 데이터가 많으니까 POST로 수신 (기본 규칙을 어기는 방식) : 좋지 않은 방식처럼 보이지만, 대다수의 업체들이 해당 방법을 사용함
	
	// [1]
	// '@GetMapping("/{pokemonNo}")'과 구분이 되는가
	@GetMapping("/column/{column}/keyword/{keyword}")
	public List<PokemonDto> search(
			@PathVariable String column,
			@PathVariable String keyword) {
		return pokemonDao.selectList(column, keyword);
	}
	
	// [2]
	@PostMapping("/search")
	public List<PokemonDto> search(@RequestBody SearchVO searchVO) {
		// return pokemonDao.selectList(searchVO.getColumn(), searchVO.getKeyword());
		return pokemonDao.selectList(searchVO);
	}
	
}
