<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- 홈페이지를 헤더, 메인, 푸터로 구분 -->
	<!-- (주의) 템플릿 페이지에서는 상대 경로를 쓸 수 없다 -->
	<div>
		<h1>
			<a href="/">
				<img src="/images/image.jpg" width="40" height="40">
				홈페이지 제작 수업
			</a>
		</h1>
	</div>

	<!-- 상태확인용 영역 -->
	<div>
		세션ID:${pageContext.session.id},
		userId:${sessionScope.userId}
	</div>
	<!-- 로그인 영역에 따라 메뉴를 다르게 표시 -->
	<div>
		<c:choose>
			<%--회원 --%>
			<c:when test="${sessionScope.userId != null }">
				<a href="/">홈</a>
				<a href="/pokemon/list">포켓몬</a> <!-- 절대경로: /pokemon/list, 상대경로: pokemon/list -->
				<a href="/country/list">국가</a>
				<a href="/game-user/list">게임유저</a>
				<a href="/member/mypage">내 정보</a>
				<a href="/member/logout">로그아웃</a>
				<a href="/board/list">게시판</a>
				<hr>
			</c:when>
			<%-- 비회원 --%>
			<c:otherwise>
				<a href="/">홈</a>
				<a href="/country/list">국가</a>
				<a href="/pokemon/list">포켓몬</a>
				<a href="/member/join">회원가입</a>
				<a href="/member/login">로그인</a>
				<hr>
				<div style="min-height:400px">
				
				
				
			</c:otherwise>
		</c:choose>
	</div>