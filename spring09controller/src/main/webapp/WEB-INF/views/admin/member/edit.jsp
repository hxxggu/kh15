<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- kakao post api -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/js/member/join.js" ></script>

<script type="text/javascript"></script>
<style>
	.field {
		border-radius: 10px;'
	}
</style>
<form action="edit" method="post" enctype="multipart/form-data" >
	<input type="hidden" name="memberId" value="${memberDto.memberId}">

<div class="container w-700">
	<div class="cell">
		<h2><i class="fa-solid fa-user-pen"></i> ${memberDto.memberId} 님의 개인정보 변경</h2>
	</div>
	<div class="cell">
		<label style="font-weight: 600">닉네임</label>&nbsp;
		<input type="text" name="memberNickname" value="${memberDto.memberNickname}" class="field" > <br><br>
	</div>
	
	<div class="cell">
		<label style="font-weight: 600">이메일</label>&nbsp;
		<input type="email" name="memberEmail" required value="${memberDto.memberEmail}" class="field" > <br><br>
	</div>	

	<div class="cell">
		<label style="font-weight: 600">생년월일</label>&nbsp;
		<input type="date" name="memberBirth" value="${memberDto.memberBirth}" class="field" > <br><br>
	</div>

	<div class="cell">
		<label style="font-weight: 600">연락처</label>&nbsp;
		<input type="tel" name="memberContact" value="${memberDto.memberContact}" class="field"> <br><br>
	</div>
	
	<div class="cell">
		<label style="font-weight: 600">등급</label>&nbsp;
		<select name="memberLevel" class="field">
			<option ${memberDto.memberLevel == '일반회원' ? 'selected' : ''}>일반회원</option>
			<option ${memberDto.memberLevel == '우수회원' ? 'selected' : ''}>우수회원</option>
		</select>
		<br><br>
	</div>
	
	<div class="cell">
		<label style="font-weight: 600">포인트</label>&nbsp;
		<input type="number" name="memberPoint" value="${memberDto.memberPoint}" class="field" style="border-radius: 10px">&nbsp;point<br><br>
	</div>

	<div class="cell">
		<div class="cell">
			<label style="font-weight: 600">주소</label>&nbsp;<br>
		</div>
		<input type="text" name="memberPost" size="6" maxlength="6" class="field" value="${memberDto.memberPost}">
		<button type="button" class="btn btn-purple"><i class="fa-solid fa-magnifying-glass"></i></button>
		<button type="button" class="btn btn-red btn-address-clear" style="display: none;">
		<i class="fa-solid fa-xmark"></i></button><br>
	    	<input type="text" name="memberAddress1" value="${memberDto.memberAddress1}" class="field" size="50" ><br>
    		<input type="text" name="memberAddress2" value="${memberDto.memberAddress2}" class="field" size="50">
	</div>

	<div class="cell">
		<button class="btn btn-pink">정보 수정</button>
		<a href="/admin/member/list" class="btn btn-blue">home</a>
	</div>
	
</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>