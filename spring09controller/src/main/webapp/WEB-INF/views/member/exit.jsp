<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-600">
    <div class="cell center">
        <h2><i class="fa-solid fa-check"></i> 비밀번호 확인</h2>
        <p>회원 탈퇴를 위해 계정 비밀번호를 입력해주세요</p>
    </div>
</div>

<div class="cell center">
	<form action="exit" method="post">
		<input type="password" name="memberPw">
		<button class="btn btn-pink">확인</button>
	</form>
	
	<c:if test="${param.error != null}">
		<h2 style="color:red">비밀번호가 일치하지 않습니다</h2>
	</c:if>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>