<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- 홈페이지를 헤더, 메인, 푸터로 구분 -->
	<!-- (주의) 템플릿 페이지에서는 상대 경로를 쓸 수 없다 -->
	<div>
		<h2>
			<a href="/">
				<img src="/images/image.jpg" width="30" height="30">
				<!-- 정적 -->
				홈페이지 제작 수업
			</a>
		</h2>
	</div>

	<!-- 상태확인용 영역 -->
	<div>
		* 세션ID : ${pageContext.session.id}<br>
		* UserID : ${sessionScope.userId}<br>
		* UserLevel : ${sessionScope.userLevel}
	</div><br>
	<!-- 로그인 영역에 따라 메뉴를 다르게 표시 -->
	<div>
		<c:choose>
			<%--회원 --%>
			<c:when test="${sessionScope.userId != null }">
				<button><a href="/">홈</a></button>
				<button><a href="/pokemon/list">포켓몬</a></button> <!-- 절대경로: /pokemon/list, 상대경로: pokemon/list -->
				<button><a href="/country/list">국가</a></button>
				<button><a href="/game-user/list">게임유저</a></button>
				<button><a href="/board/list">게시판</a></button>
				<button><a href="/member/mypage">내 정보</a></button>
				<button><a href="/member/logout">로그아웃</a></button>
				
				<c:if test="${sessionScope.userLevel == '관리자' }">
					<button><a href="/admin/home">*관리자 메뉴</a></button>
				</c:if>
				<hr>
			</c:when>
			<%-- 비회원 --%>
			<c:otherwise>
				<button><a href="/">홈</a></button>
				<button><a href="/country/list">국가</a></button>
				<button><a href="/pokemon/list">포켓몬</a></button>
				<button><a href="/member/join">회원가입</a></button>
				<button><a href="/member/login">로그인</a></button>
				<hr>
			</c:otherwise>
		</c:choose>
	</div>