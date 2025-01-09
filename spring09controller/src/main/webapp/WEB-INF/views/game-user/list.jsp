<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>유저 목록</h1>

<form action="list" method="get">
	<select name="column">
		<option>아이디
		<option>레벨
		<option>직업
	</select>
	<input type="text" name="keyword" value="${keyword}" required>
	<button>검색</button>
</form>

<!-- 데이터 표시 영역 -->
<c:forEach var="gameUserDto" items="${list}">
	<h2>
		[ ${gameUserDto.gameUserJob} ],
		${gameUserDto.gameUserId},
		Level. ${gameUserDto.gameUserLevel}
	</h2>
</c:forEach>