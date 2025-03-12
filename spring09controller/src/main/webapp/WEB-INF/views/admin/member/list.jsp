<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2><i class="fa-regular fa-user purple"></i> 회원 관리</h2>

<!-- 검색창 -->
<form action="list" method="get">
	<select name="column" style="border: none; width: 120px;">
		<option value="member_id" ${pageVO.column == 'member_id' ? 'selected' : ''}>아이디</option>
		<option value="member_nickname" ${pageVO.column == 'member_nickname' ? 'selected' : ''}>닉네임</option>
		<option value="member_birth" ${pageVO.column == 'member_birth' ? 'selected' : ''}>생년월일</option>
		<option value="member_contact" ${pageVO.column == 'member_contact' ? 'selected' : ''}>연락처</option>
		<option value="member_email" ${pageVO.column == 'member_email' ? 'selected' : ''}>이메일</option>
	</select>
	<input type="text" name="keyword" value="${pageVO.keyword}" >
	<button class="btn btn-pink" style="border-radius: 10px; ">검색</button>
	
</form>


<!-- 테이블 출력 -->
<br>
<table border="1" width="800">
	<thead>
		<tr>
			<th>아이디</th>
			<th>닉네임</th>
			<th>생년월일</th>
			<th>연락처</th>
			<th>이메일</th>
			<th>가입일</th>
			<th>등급</th>
		</tr>
	</thead>
	
	<tbody align="center">
		<c:forEach var="memberDto" items="${list}">
		<tr>
			<td>
				<a href="detail?memberId=${memberDto.memberId}">
					${memberDto.memberId}
				</a>
			</td>
			<td>${memberDto.memberNickname}</td>
			<td>${memberDto.memberBirth}</td>
			<td>${memberDto.memberContact}</td>
			<td>${memberDto.memberEmail}</td>
			<td>
				<fmt:formatDate value = "${memberDto.memberJoin}" pattern="yyyy-MM-dd"/>
			</td>
			<td>${memberDto.memberLevel}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<br>
<div class="cell">
	<a href="/admin/home" class="btn btn-pink" style="border-radius: 10px"><i class="fa-solid fa-user-tie black"></i> 관리자 홈</a>
	<a href="/" class="btn btn-purple" style="border-radius: 10px"><i class="fa-solid fa-house"></i> 메인</a>
</div>


<!-- 페이지 네비게이터 -->
<jsp:include page="/WEB-INF/views/template/pagination.jsp"></jsp:include> <!-- 해당 구문을 사용하기 위해서는 pageVO를 꼭 넘겨줘야 함 -->

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>