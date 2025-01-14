<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>개인정보 변경</h2>

<form action="change" method="post">
	<h5 style="color: red"><b>*필수입력항목</b></h5> 
	<b style="color: red">*</b> 닉네임 <input type="text" name="memberNickname" value="${memberDto.memberNickname}" required><br><br>
	<b style="color: red">*</b> 이메일 <input type="email" name="memberEmail" value="${memberDto.memberEmail}" required><br><br>
	생년월일 <input type="date" name="memberBirth" value="${memberDto.memberBirth}"><br><br>
	연락처 <input type="tel" name="memberContact" value="${memberDto.memberContact}"><br><br>
	주소<br>
	<input type="text" size="6" name="memberPost" value="${memberDto.memberPost}"><br>
	<input type="text" size="60" name="memberAddress1" value="${memberDto.memberAddress1}"><br>
	<input type="text" size="60" name="memberAddress2" value="${memberDto.memberAddress2}"><br>
	<br>
	<b style="color: red">*</b> 비밀번호 확인 <input type="password" name="memberPw" required><br><br>
	<button>정보 수정</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>