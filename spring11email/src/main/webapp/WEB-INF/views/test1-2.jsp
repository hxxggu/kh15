<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h2>인증 번호 입력</h2>

<form action="test1-3" method="post">
	<input type="hidden" name="certEmail" value="${param.email}">
	<input type="text" inputmode="numeric" name="certNumber">
	<button type="submit">인증 번호 확인</button>
</form>