<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="change" method="post">
<div class="container w-800">
	<div class="cell">
	    <h2><i class="fa-regular fa-user"></i> 계정 정보 수정</h2>
	</div>

	<i class="fa-solid fa-angle-right"></i> 닉네임 <input type="text" name="memberNickname" value="${memberDto.memberNickname}" ><br><br>
	<i class="fa-solid fa-angle-right"></i> 이메일 <input type="email" name="memberEmail" value="${memberDto.memberEmail}"><br><br>
	<i class="fa-solid fa-angle-right"></i> 생년월일 <input type="date" name="memberBirth" value="${memberDto.memberBirth}"><br><br>
	<i class="fa-solid fa-angle-right"></i> 연락처 <input type="text" name="memberContact" value="${memberDto.memberContact}"><br><br>
	<i class="fa-solid fa-angle-right"></i> 이메일 <input type="email" name="memberEmail" value="${memberDto.memberEmail}" ><br><br>
	<i class="fa-solid fa-angle-right"></i>주소<br>
		  <input type="text" name="memberPost" size="10" maxlength="6"  value="${memberDto.memberPost}" class="field">
		  <button type="button" class="btn btn-purple btn-address-search""><i class="fa-solid fa-magnifying-glass"></i></button>
		  <button type="button" class="btn btn-negative btn-address-clear" style="display: none;">
		        <i class="fa-solid fa-xmark"></i>
		   </button><br>
		   <input type="text" name="memberAddress1" size="60" value="${memberDto.memberAddress1}" class="field"><br>
		   <input type="text" name="memberAddress2" size="60" value="${memberDto.memberAddress2}" class="field"><br>
	<div class="cell">
	   <i class="fa-solid fa-angle-right"></i> 비밀번호 확인
	   <input type="password" name="memberPw"><br>
	</div>
	   <button class="btn btn-pink" style="border-radius: 10px;">정보 수정</button> 
</div>
	


<c:if test="${param.error != null}">
	<h2 style="color:red">비밀번호가 일치하지 않습니다</h2>
</c:if>
</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>