<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>가입 정보 입력</h1>

<form action="join" method="post">
	<b style="color: red">*필수 입력 항목</b><br><br>
	<b style="color: red">*</b>아이디 <input name="memberId" type="text" required><br><br>
	<b style="color: red">*</b>비밀번호<input name="memberPw" type="password" required><br><br>
	<b style="color: red">*</b>닉네임<input name="memberNickname" type="text" required><br><br>
	<b style="color: red">*</b>이메일 <input name="memberEmail" type="email" required><br><br>
	<b style="color: red">*</b>생년월일 <input name="memberBirth" type="date" required><br><br>
	연락처 <input name="memberContact" type="tel"><br><br> <!-- (type) text: 쿼티창이 나옴 / tel: 전화번호 입력창이 나옴 (모바일 상에서) --> 
	주소<br><br> 
	<input name="memberPost" type="text" size="6" placeholder="우편번호"><br><br>
	<input name="memberAddress1" type="text" size="60" placeholder="기본 주소"><br><br>
	<input name="memberAddress2" type="text" size="60" placeholder="상세 주소"><br><br>
	
	<button>회원가입</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>