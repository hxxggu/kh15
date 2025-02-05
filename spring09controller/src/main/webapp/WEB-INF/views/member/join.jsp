<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="join" method="post" enctype="multipart/form-data" autocomplete="off">
	<div class="container w-400">
		<div class="cell center">
		     <h2>회원 가입</h2>
		 </div>
		 <div class="cell">
		     <label>* ID</label>
		     <input type="text" name="memberId" class="field w-100" required>
		 </div>
		 <div class="cell">
		     <label>* Password</label>
		     <input type="password" name="memberPw" class="field w-100" required>
		 </div>
		 <div class="cell">
		     <label>* 닉네임</label>
		     <input type="text" name="memberNickname" class="field w-100" required>
		 </div>
		 <div class="cell">
		     <label>* E-mail</label>
		     <input type="email" name="memberEmail" class="field w-100" required>
		 </div>
		 <div class="cell">
		     <label>* 생년월일</label>
		     <input type="date" name="memberBirth" class="field w-100" required>
		 </div>
		 <div class="cell">
		     <label>전화번호</label>
		     <input type="tel" name="memberTel" class="field w-100">
		 </div>
		 <div class="cell">
		     <label>주소</label><br>
		     <input type="text" name="memberPost" class="field w-40" placeholder="우편번호">
		     <button class="btn btn-neutral">검색</button>
		     <input type="text" name="memberAddress1" class="field w-100" placeholder="기본 주소"><br>
		     <input type="text" name="memberAddress2" class="field w-100" placeholder="상세 주소">
		 </div>
		 <div class="cell center">
		     <button class="btn btn-positive w-100">가입하기</button>
		 </div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>