<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="findPw" method="post" autocapitalize="off">
	<div class="container w-500">
	
		<div class="cell center">
			<h2>비밀번호 찾기</h2>
			<p>비밀번호를 찾고자하는 아이디와 이메일을 입력해주세요</p>
		</div>
		
		<div class="cell">
			<label><i class="fa-regular fa-user"></i> 아이디</label>
			<input type="text" name="memberId" class="field w-100" placeholder="* 아이디 입력">
		</div>
		
		<div class="cell">
			<label><i class="fa-solid fa-envelope"></i> 이메일</label>
			<input type="email" inputmode="email" name="email" class="field w-100" placeholder="* 이메일 입력">
		</div>
		
		<div class="cell mt-20">
			<button type="submit" class="btn btn-pink w-100">
				<span>재설정 메일 전송</span> <!-- 글자 혼자 돌아다니지 않게 항상 span 처리 -->
			</button>
		</div>
	</div>
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>