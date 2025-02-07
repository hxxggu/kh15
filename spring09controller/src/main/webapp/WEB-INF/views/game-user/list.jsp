<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-700">
	<div class="cell center">
		<h1>게임 유저 목록</h1>
	</div>
	<!-- 검색창 -->
	<div class="cell center">
		<form action="list" method="get">
			<select name="column" class="field">
				<option ${column=='아이디' ? 'selected' : ''}>아이디</option>
				<option ${column=='직업' ? 'selected' : ''}>직업</option>
			</select>
			<input type="search" name="keyword" value="${keyword}" class="field">
			<button class="btn btn-positive">검색</button>
		</form>
	</div>
	
	<div class="cell right">
		<a href="add" class="btn btn-neutral">+ 신규 유저 생성하기</a>
	</div>
	
	<!-- 테이블 -->
	<div class="cell">
		<table class="table table-border table-stripe">
			<thead>
				<tr>
					<th>아이디</th>
					<th>직업</th>
					<th>레벨</th>
					<th>메뉴</th>
				</tr>
			</thead>
			<tbody class="center">
				<c:forEach var="gameUserDto" items="${list}">
				<tr>
					<td>${gameUserDto.gameUserId}</td>
					<td>${gameUserDto.gameUserJob}</td>
					<td>${gameUserDto.gameUserLevel}</td>
					<td>
						<a href="detail?gameUserNo=${gameUserDto.gameUserNo}">
							상세
						</a>
					</td>
				</tr>
				</c:forEach>		
			</tbody>
		</table>
	</div>
	
	<div class="cell right">
		<a href="add" class="btn btn-neutral">+ 신규 유저 생성하기</a>
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>



