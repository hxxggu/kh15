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
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		if(userId == null) throw new NoPermissionException("접근 권한이 없습니다");
		
		String memberLevel = request.getParameter("memberLevel");
		MemberDto memberDto = memberDao.selectOne(memberLevel);
				
		if(memberLevel == "관리자") {
			return true;
		} else {
			throw new NoPermissionException("접근 권한이 없습니다");
		}
	}
	
	
}
