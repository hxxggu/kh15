<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>My Page</h2>

<table border="1" width="400">
	<tr>
		<th width="25%">프로필 사진</th>
		<td></td>
	</tr>
	<tr>
		<th>ID</th>
		<td>${memberDto.memberId}</td>
	</tr>
	<tr>
		<th>닉네임</th>
		<td>${memberDto.memberNickname}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${memberDto.memberEmail}</td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td>${memberDto.memberBirth}</td>
	</tr>
	<tr>
		<th>연락처</th>
		<td>${memberDto.memberContact}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>
			[${memberDto.memberPost}]<br>
			${memberDto.memberAddress1}<br>
			${memberDto.memberAddress2}<br>
		</td>
	</tr>
	<tr>
		<th>등급</th>
		<td>${memberDto.memberLevel}</td>
	</tr>
	<tr>
		<th>포인트</th>
		<td>${memberDto.memberPoint}</td>
	</tr>
	<tr>
		<th>가입 일시</th>
		<td>
			<fmt:formatDate value = "${memberDto.memberJoin}" pattern="y년 M월 d일 a h시 m분 s초"/>
		</td>
	</tr>
	<tr>
		<th>최종 로그인</th>
		<td>
			<fmt:formatDate value = "${memberDto.memberLogin}" pattern="y년 M월 d일 a h시 m분 s초"/>
		</td>
	</tr>
	<tr>
		<th>비밀번호<br>변경일</th>
		<td>
			<fmt:formatDate value = "${memberDto.memberChange}" pattern="y년 M월 d일 a h시 m분 s초"/>
		</td>
	</tr>
</table>

<br><br>
<button><a href="password">비밀번호 변경</a></button> <!-- end point(마지막 /)가 같다 -->
<button><a href="change">개인정보 변경</a></button>
<button><a href="exit">회원 탈퇴</a></button>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>