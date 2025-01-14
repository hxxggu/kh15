<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>비밀번호 변경</h2>

<form action="password" method="post">
	현재 비밀번호 <input type="text" name="currentPw" required><br><br>
	신규 비밀번호 <input type="text" name="newPw" required><br><br>
	<button>변경</button>
</form>

<!-- error에 대해서 디테일을 주고 싶으면 error에 value를 넣어서 구분하면 쉽게 처리가 가능 -->
<c:if test = "${param.error == '1'}">
	<h2 style="color:red">비밀번호가 일치하지 않습니다</h2> 
</c:if>
<c:if test = "${param.error == '2'}">
	<h2 style="color:red">같은 비밀번호로는 변경할 수 없습니다</h2>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>