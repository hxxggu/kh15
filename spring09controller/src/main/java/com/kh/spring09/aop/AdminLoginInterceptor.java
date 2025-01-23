package com.kh.spring09.aop;

import javax.naming.NoPermissionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class AdminLoginInterceptor implements HandlerInterceptor {
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//목표 : 비회원이나 관리자가 아닌 회원이 통과하는 것을 차단
		HttpSession session = request.getSession();
		String userLevel = (String)session.getAttribute("userLevel");
		if(userLevel == null) throw new NoPermissionException("접근 권한이 없습니다"); //비회원
		if(userLevel.equals("관리자") == false) throw new NoPermissionException("접근 권한이 없습니다");
		
		return true;
	}
}
