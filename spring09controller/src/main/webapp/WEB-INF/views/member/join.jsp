<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- Lightpick 라이브러리 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/lightpick@1.6.2/css/lightpick.min.css">
<script src="https://cdn.jsdelivr.net/npm/moment@2.30.1/moment.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/lightpick@1.6.2/lightpick.min.js"></script>

<!-- kakao post api -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/js/member/join.js" ></script>

<form action="join" method="post" enctype="multipart/form-data" autocomplete="off">

	<div class="container w-500">
	
		<div class="cell center">
		     <h2>Join In</h2>
		     <p>회원 정보 입력</p>
		 </div>
		 
		<div class="cell">
		    <label><i class="fa-regular fa-user"></i> ID</label>
		    <input type="text" name="memberId" class="field w-100" placeholder="* 아이디">
		    <div class="fail-feedback">형식에 맞지 않는 아이디 입니다</div>
		    <div class="fail2-feedback">이미 존재하는 아이디 입니다</div>
		    <div class="success-feedback">올바른 아이디 입니다</div>
		</div>
		
		<div class="cell">
		    <label><i class="fa-solid fa-lock"></i> Password </label>
		    <input type="password" name="memberPw" class="field w-100" placeholder="* 비밀번호">
		    <div class="fail-feedback">비밀번호가 형식에 맞지 않습니다</div>
		    <div class="success-feedback">비밀번호 입력 완료</div>
		</div>
		<div class="cell">
		    <label><i class="fa-solid fa-lock"></i> Password Check </label>
		    <input type="password" id="pw-reinput" class="field w-100" placeholder="* 비밀번호 확인">
		    <div class="success-feedback">비밀번호가 일치합니다</div>
		    <div class="fail-feedback">비밀번호가 일치하지 않습니다</div>
		    <div class="fail2-feedback">비밀번호를 우선 입력해주세요</div>
		</div>
		 
		<div class="cell">
			<label><i class="fa-regular fa-face-kiss-wink-heart"></i> Nickname</label>
			<input type="text" name="memberNickname" class="field w-100" placeholder="[필수] 닉네임">
			<div class="fail-feedback">형식에 맞지 않는 닉네임 입니다</div>
			<div class="success-feedback">입력 완료</div>
		</div>
		
	    <div class="cell">
	        <label><i class="fa-regular fa-envelope"></i> 이메일</label>
	    </div>
	    <div class="cell">
	        <input type="email" inputmode="email" name="memberEmail" class="field" maxlength="30">
	        <button type="button" class="btn btn-purple btn-send-cert">
	        	<i class="fa-solid fa-paper-plane"></i>
	        	<span>인증메일 발송</span>
	        </button>
	        <div class="fail-feedback">이메일은 필수 항목입니다</div>
	    </div>
	    <div class="cell cert-input-wrapper" style="display:none;">
	    	<input type="text" inputmode="numeric" class="field"
	    				name="certNumber" placeholder="인증번호 입력">
	    	<button type="button" class="btn btn-positive btn-confirm-cert">
	    		<i class="fa-solid fa-check"></i>
	    		<span>인증 확인</span>
	    	</button>
			<div class="success-feedback">인증이 완료되었습니다</div>
	    	<div class="fail-feedback">인증 번호가 일치하지 않습니다</div>
	    </div>

		
		<div class="cell">
		    <label><i class="fa-solid fa-cake-candles"></i> 생년월일</label>
		    <input type="text" name="memberBirth" class="field w-100">
		    <div class="fail-feedback">생년월일을 입력해주세요</div>
		    <div class="success-feedback">생년월일 입력 완료</div>
		</div>

		<div class="cell">
		    <label> <i class="fa-solid fa-mobile-screen-button"></i> Contact</label>
		    <input type="tel" name="memberContact" class="field w-100" placeholder="* 휴대전화번호">
		    <div class="fail-feedback">형식이 맞지 않습니다</div>
		    <div class="success-feedback"></div>
		</div>
		
		<div class="cell">
		    <label><i class="fa-solid fa-location-dot"></i> 주소</label>
		</div>
		<div class="cell">
		    <input type="text" name="memberPost" size="6" maxlength="6" class="field" placeholder="우편번호">
		    <button type="button" class="btn btn-purple"><i class="fa-solid fa-magnifying-glass"></i></button>
		    <button type="button" class="btn btn-red btn-address-clear" style="display: none;">
		        <i class="fa-solid fa-xmark"></i>
		    </button>
		</div>
		<div class="cell">
		    <input type="text" name="memberAddress1" class="field w-100" placeholder="기본주소">
		</div>
		<div class="cell">
		    <input type="text" name="memberAddress2" class="field w-100" placeholder="상세주소">
		    <div class="fail-feedback">주소는 모두 작성하셔야 합니다</div>
		</div>

		<div class="cell center">
		    <button class="btn btn-pink w-100">가입하기</button>
		</div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>