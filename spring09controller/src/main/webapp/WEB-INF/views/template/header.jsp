<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH15 HomePage</title>
</head>
<body>

<!-- 홈페이지를 헤더, 메인, 푸터로 구분 -->
<!-- (주의) 템플릿 페이지에서는 상대 경로를 쓸 수 없다 -->
<div>
	<h1>
		<a href="/">
			<img src="/spring09intergrated/src/main/resources/static/images/image.jpg" width="150" height="30">
			홈페이지 제작 수업
		</a>
	</h1>
</div>
<div>
	<a href="/">홈</a>
	<a href="/pokemon/list">포켓몬</a> <!-- 절대경로: /pokemon/list, 상대경로: pokemon/list -->
	<a href="/country/list">국가</a>
	<a href="/game-user/list">게임유저</a>
	<a href="/member/join">회원가입</a>
	<a href="#">로그인</a>
</div>
<hr>
<div>