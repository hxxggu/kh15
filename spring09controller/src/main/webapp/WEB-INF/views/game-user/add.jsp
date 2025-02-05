<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<br>
<form action="add" method="post" enctype="multipart/form-data" autocomplete="off">
	<div class="container w-400">
		<div class="cell center">
		    <h2>[ 게임 유저 등록 (운영자) ]</h2>
		</div>
		<div class="cell">
		    <label>* 아이디</label>
		    <input type="text" name="gameUserId" class="field w-100">
		</div>
		<div class="cell">
		    <label>* 직업</label>
		    <select name="gameUserJob" required class="field w-100">
		        <option>선택하세요</option>
		        <option>전사</option>
		        <option>성직자</option>
		        <option>도적</option>
		    </select>
		</div>
		<div class="cell">
		    <label>* 레벨</label>
		    <input type="text" name="gameUserLevel" class="field w-100" required>
		</div>
		<div class="cell">
		    <label>* 소지금</label>
		    <input type="text" name="gameUserMoney" class="field w-100" required>
		</div>
		<div class="cell">
		    <label>프로필</label>
		    <input type="file" name="attach" class="field w-100">
		</div>
		<div class="cell">
		    <button type="submit" class="btn btn-positive w-100">등록하기</button>
		</div>
	</div>
</form>
<br>
<hr>
<br>
<form action="add" method="post" enctype="multipart/form-data" autocomplete="off">
	<div class="container w-400">
		<div class="cell center">
		    <h2>[ 게임 유저 등록 (사용자) ]</h2>
		</div>
		<div class="cell">
		    <label>* ID</label>
		    <input type="text" name="gameUserId" required class="field w-100">
		</div>
		<div class="cell">
		    <label>* 직업</label>
		    <select name="gameUserJob" required class="field w-100">
		        <option value="">선택하세요</option>
		        <option>전사</option>
		        <option>성직자</option>
		        <option>도적</option>
		    </select>
		</div>
		<div class="cell">
		    <label>프로필</label>
		    <input type="file" name="attach" class="field w-100">
		</div>
		<div class="cell">
		    <button type="submit" class="btn btn-positive w-100">등록하기</button>
		</div>
	</div>
</form>
<br>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>