<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>이메일 인증 테스트</h2>

<h3> [1] 동기 방식으로 인증 메일 보내기 </h3>

<form aciton="test1" method="post">
	<input type="email"  inputmode="email" name="email">
	<button type="submit">인증 메일 보내기</button>
</form>