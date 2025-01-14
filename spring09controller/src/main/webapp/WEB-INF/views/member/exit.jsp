<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<h2><b>비밀번호 확인</b></h2>
<p>회원 탈퇴를 위해 비밀번호를 입력해주세요</p>

<form action="exit" method="post">
	<input type="password" name="memberPw">
	<button>확인</button>
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>