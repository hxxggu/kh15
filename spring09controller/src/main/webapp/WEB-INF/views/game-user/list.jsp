<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>게임 유저 목록</h1>
<h2><a href="add">신규 유저 생성하기</a></h2>

<!-- 검색창 -->
<form action="list" method="get">
	<select name="column">
		<option ${column=='아이디' ? 'selected' : ''}>아이디</option>
		<option ${column=='직업' ? 'selected' : ''}>직업</option>
	</select>
	<input type="search" name="keyword" value="${keyword}">
	<button>검색</button>
</form>

<!-- 데이터 표시 영역 -->
<table border="1" width="600">
	<thead>
		<tr>
			<th>아이디</th>
			<th>직업</th>
			<th>레벨</th>
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="gameUserDto" items="${list}">
		<tr>
			<td>${gameUserDto.gameUserId}</td>
			<td>${gameUserDto.gameUserJob}</td>
			<td>${gameUserDto.gameUserLevel}</td>
		</tr>
		</c:forEach>		
	</tbody>
</table>