<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>게임 유저 등록(운영자)</h1>
<form action="add" method="post">
	아이디 <input name="gameUserId" type="text" required placeholder="(ex) 피카츄"> <br><br>
	직업
	<select name="gameUserJob" required>
		<option value="">선택하세요</option>
		<option>전사</option>
		<option>성직자</option>
		<option>도적</option>
	</select>
	<br><br>
	레벨 <input name="gameUserLevel" type="number"> <br><br>
	골드 <input name="gameUserMoney" type="number"> <br><br>
	<button>등록</button>
</form>
<hr>
<h1>게임 유저 등록(사용자)</h1>
<form action="add" method="post">
	아이디 <input name="gameUserId" type="text" required placeholder="(ex) 피카츄"> <br><br>
	직업
	<select name="gameUserJob" required>
		<option value="">선택하세요</option>
		<option>전사</option>
		<option>성직자</option>
		<option>도적</option>
	</select>
	<br><br>
	<button>등록</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>