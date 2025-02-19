<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2><i class="fa-solid fa-arrow-right-to-bracket"></i> 로그인</h2>

<form action="login" method="post">
	<i class="fa-solid fa-id-badge"></i> 아이디 <input type="text" name="memberId"><br><br>
	<i class="fa-solid fa-lock"></i> 비밀번호 <input type="password" name="memberPw"><br><br>
	<button class="btn btn-purple">Login</button>
	<a href="join" class="btn btn-purple">Join</a>
</form>

<!-- if(error라는 파라미터가 있으면) { -->
<c:if test="${param.error != null}">
	<h3 style="color:red">아이디 혹은 비밀번호가 일치하지 않습니다</h3>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>