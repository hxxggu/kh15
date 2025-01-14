package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.MemberDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	
	//회원가입 매핑
	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
		return "redirect:join-finish";
	}
	@RequestMapping("/join-finish") //주소에는 대문자를 잘 쓰지 않음. 쓸 수 있는 경우가 있고, 없는 경우가 있음.
	public String joinFinish() {
		return "/WEB-INF/views/member/join-finish.jsp";
	}
	
	//로그인 매핑
	@GetMapping("/login")
	public String login() {
		return "/WEB-INF/views/member/login.jsp";
	}
	
	//HttpSession 추가
	//- 사용자별로 무언가 다른 정보를 기록해야 할 필요가 있을 때 사용
	//- Model처럼 선언만 하면 자동으로 스프링이 제공해 줌
	//- 데이터 추가: session.setAttribute("key", value);
	//- 데이터 추출: session.getAttribute("key");
	//- 데이터 제거: session.removeAttribute("key");
	//- 목표 : 로그인 성공 시 이 회원의 정보를 세션에 저장 (PK)
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
		MemberDto findDto = memberDao.selectOne(memberDto.getMemberId());
		//아이디가 없으면 findDto는 null이다
		if(findDto == null) { //아이디 없음
			return "redirect:login ? error"; //로그인 페이지로 쫓아낸다
		} //아이디가 있으면 비밀번호 검사를 진행
		boolean isValid = findDto.getMemberPw().equals(memberDto.getMemberPw());
		if(isValid) { //로그인 성공 시
			
			//(+추가) 세션에 userId란 이름으로 사용자의 ID를 저장
			session.setAttribute("userId", findDto.getMemberId());
			//(+추가) 최종 로그인 시각을 갱신 처리
			memberDao.updateMemberLogin(findDto.getMemberId());
			return "redirect:/";
			} else { //비밀번호 다름
			return "redirect:login ? error"; //로그인페이지로 쫓아낸다
		}	
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
//		session.invalidate(); //세션 소멸 명령
		return "redirect:/";
	}
	
	//마이페이지(내 정보) 매핑
	//- 현재 로그인한 회원의 모든 정보가 화면에 출력(단, 비밀번호 제외)
	//- HttpSession에 있는 아이디를 꺼내 회원의 모든 정보를 조회
	@RequestMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId"); //업캐스팅<>다운캐스팅
		MemberDto memberDto = memberDao.selectOne(userId); //내 정보 획득
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/mypage.jsp"; //redirect<>forward
		//redirect는 특정 페이지 접속 시 다른 페이지로 이동시킴. 사용자는 처음 요청한 url와 다른 url에 접속함.
		//forward는 servlet에서 직접 다른 url을 처리하여 response. 클라이언트가 http request를 두번 요청하지 않음.
	}
	
	@RequestMapping("/password-finish")
	public String passwordFinish(){
		return "/WEB-INF/views/member/password-finish";
	}
	
	@GetMapping("/password")
	public String password() {
		return "/WEB-INF/views/member/password.jsp";
	}
	@PostMapping("/password")
	public String password(
			@RequestParam String currentPw,
			@RequestParam String newPw, HttpSession session) {
		String userId = (String) session.getAttribute("userId"); //*세션은 object를 받음 / *원래대로 돌리는 것: 다운캐스팅
		//비밀번호 비교는 java에서 실행
		MemberDto memberDto = memberDao.selectOne(userId);
		boolean isValid = currentPw.equals(memberDto.getMemberPw());
		if(isValid == false) return "redirect:password?error=1"; //비밀번호가 일치하지 않는 경우는 되돌린다(redirect)
		//error에 value를 줘서 알아볼 수 있게 차별화를 시킴 (Ex. error=1)
		
		//(+추가)동일한 비밀번호로는 변경할 수 없도록 차단 처리
		if(currentPw.equals(newPw)) {
			return "redirect:password?error=2";
		}
		
		memberDto.setMemberPw(newPw); //비밀번호 변경
		memberDao.updateMemberPassword(memberDto); //이왕이면 Dto 사용하는 것을 지양
		return "redirect:mypage";
	}
	
	
	
	
}
