<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>회원 목록 및 검색</h2>
<form action="list" method="get">
	<select name="column">
		<option ${column=='아이디' ? 'selected' : ''}>아이디</option>
		<option ${column=='닉네임' ? 'selected' : ''}>닉네임</option>
	</select>
	<input type="search" name="keyword" value="${keyword}">
	<button>검색</button>
</form>

<table border="1" width="600">
	<thead>
		<tr>
			<th>ID</th>
			<th>닉네임</th>
		</tr>
	</thead>
		
	<tbody align="center">
		<c:forEach var="memberDto" items="${list}">
		<tr>
			<td>
				<a href="detail?memberId=${memberDto.memberId}">
					${memberDto.memberId}
				</a>
			</td>
			<td>${memberDto.memberNickname}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>