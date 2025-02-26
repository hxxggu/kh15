<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-500">
	<div class="cell center">
		<h2>비밀번호 재설정 완료</h2>
		<p>변경된 비밀번호로 로그인 해주세요</p>
	</div>
	<div class="cell">
		<a class="btn btn-purple w-100" href="login">
			<i class="fa-solid fa-right-to-bracket"></i>
			<span>로그인하러 가기</span>
		</a>
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>