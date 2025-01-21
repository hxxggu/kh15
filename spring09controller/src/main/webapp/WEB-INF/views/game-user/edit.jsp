<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>사용자 정보 수정</h2>

<form action="edit" method="post" enctype="multipart/form-data">
	<input type="hidden" name="gameUserNo" value="${gameUserDto.gameUserNo}">
	*ID <input type="text" name="gameUserId" value="${gameUserDto.gameUserId}" required><br><br>
	*직업
	<select name="gameUserJob" required>
		<option ${gameUserDto.gameUserJob} == '전사'? 'selected' : ">전사</option>
		<option ${gameUserDto.gameUserJob} == '성직자'? 'selected' : ">성직자</option>
		<option ${gameUserDto.gameUserJob} == '도적'? 'selected' : ">도적</option>
	</select>
	<br><br>
	*레벨 <input type="number" name="gameUserLevel" value="${gameUserDto.gameUserLevel}" required><br><br>
	*소지금 <input type="number" name="gameUserMoney" value="${gameUserDto.gameUserMoney}" required><br><br>
	프로필 <input type="file" name="attach"><br><br>
	<small>*미설정 시 현상태 유지</small>
	<button>정보수정</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>