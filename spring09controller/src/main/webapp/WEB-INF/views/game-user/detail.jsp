<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>사용자 정보</h1>

<img src="profile?gameUserNo=${gameUserDto.gameUserNo}" width="300">
<br><br>
<table border="1" width="300">
	<tr>
		<th width="30%">번호</th>
		<td>${gameUserDto.gameUserNo}</td>
	</tr>
	<tr>
		<th>ID</th>
		<td>${gameUserDto.gameUserId}</td>
	</tr>
	<tr>
		<th>직업</th>
		<td>${gameUserDto.gameUserJob}</td>
	</tr>
	<tr>
		<th>레벨</th>
		<td>Level ${gameUserDto.gameUserLevel}</td>
	</tr>
	</tr>
	<tr>
		<th>소지금</th>
		<td>
			<fmt:formatNumber pattern="#,##0" 
			value="${gameUserDto.gameUserMoney}">
			</fmt:formatNumber>
		</td>
	</tr>
</table>

<h2>
	<button><a href="add">신규 유저 등록</a></button>
	<button><a href="list">유저 목록</a></button>
	<button><a href="edit?gameUserNo=${gameUserDto.gameUserNo}">수정</a></button>
	<button><a href="delete?gameUserNo=${gameUserDto.gameUserNo}">삭제</a></button>
	<button><a href="levelup?gameUserNo=${gameUserDto.gameUserNo}">레벨업</a></button>
</h2>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>