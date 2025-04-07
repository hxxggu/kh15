package com.kh.spring12.restcontroller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.AccountDao;
import com.kh.spring12.dto.AccountDto;
import com.kh.spring12.error.TargetNotFoundException;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.AccountInsertVO;
import com.kh.spring12.vo.AccountSignInResponseVO;
import com.kh.spring12.vo.AccountSignInVO;
import com.kh.spring12.vo.ClaimVO;

@CrossOrigin
@RestController
@RequestMapping("/api/account")
public class AccountRestController {
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/")
	public void join(@RequestBody AccountInsertVO accountInsertVO) {
		// vo → dto 변경 (ModelMapper)
		ModelMapper mapper = new ModelMapper();
		AccountDto accountDto = mapper.map(accountInsertVO, AccountDto.class);
		
		accountDao.insert(accountDto);
	}
	
	// 로그인
	// @GetMapping("/accountId/{accountId}/accountPw/{accountPw}")
	@PostMapping("/login")
	public AccountSignInResponseVO login(@RequestBody AccountSignInVO vo) {
		// 사용자가 입력한 내용을 AccountDto로 변환 (아이디/비밀번호)
		ModelMapper mapper = new ModelMapper();
		AccountDto accountDto = mapper.map(vo, AccountDto.class);
		
		// 데이터베이스 탐색 (+비밀번호 비교)
		AccountDto findDto = accountDao.login(accountDto);
		if(findDto == null) throw new TargetNotFoundException("정보 불일치");
		
		// 로그인 성공
		// 사용자가 받아야 할 데이터를 생성하고 반환
		return AccountSignInResponseVO.builder()
					.userId(findDto.getAccountId())
					.userLevel(findDto.getAccountLevel())
					.accessToken(tokenService.generateAccessToken(findDto)) // accountDto: 아이디와 비밀번호만 존재
					.refreshToken(tokenService.generateRefreshToken(findDto)) // 해당 토큰은 만들어지면서 DB에 기록이 되어야 함
				.build();
	}
	
	// 로그인 갱신 기능 (refreshToken을 사용)
	// - 헤더에 Authorization 항목으로 여태까지 인증에 사용했으니
	// - 갱신할 때도 Authorization 항목에 refreshToken을 담아서 보내라
	@PostMapping("/refresh")
	public AccountSignInResponseVO refresh(
		@RequestHeader("Authorization") String refreshToken
	) {
		// [1] refreshToken이 없거나 Bearer 토큰이 아니면 차단		
		// [2] 토큰을 해석하여 ClaimVO를 추출
		ClaimVO claimVO = tokenService.parseBearerToken(refreshToken);
		// [3] userId와 refreshToken을 이용하여 발급 내용을 조회(DB)
		// [4] 기존 발급 내역을 삭제
		// boolean isValid = accountTokenDao.checkBearerToken(claimVO, refreshVO);
		boolean isValid = tokenService.checkBearerToken(claimVO, refreshToken); // service의 느낌이 강할 때에는 dao보다 service를 쓰는 것이 적절
		if(isValid == false) throw new TargetNotFoundException("정보 불일치");
		// [5] 신규 로그인 정보 재발행 및 반환 (accessToken, refreshToken 재발행)
		return AccountSignInResponseVO.builder()
					.userId(claimVO.getUserId())
					.userLevel(claimVO.getUserLevel())
					.accessToken(tokenService.generateAccessToken(claimVO))
					.refreshToken(tokenService.generateRefreshToken(claimVO)) // 오버로딩(overloading)이 필요한 상황
				.build();
	}
	
	@GetMapping("/accountId/{accountId}")
	public void findAccountId(@PathVariable String accountId) {
		AccountDto accountDto = accountDao.selectOne(accountId);
		if(accountDto == null) 
			throw new TargetNotFoundException();//404처리
	}
	@GetMapping("/accountNickname/{accountNickname}")
	public void findAccountNickname(@PathVariable String accountNickname) {
		AccountDto accountDto = accountDao.selectOneByAccountNickname(accountNickname);
		if(accountDto == null)
			throw new TargetNotFoundException();//404처리
	}
}