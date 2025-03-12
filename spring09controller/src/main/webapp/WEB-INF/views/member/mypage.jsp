<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

    <div class="container w-900">
        <div class="cell">
            <div class="cell">
                <h2><i class="fa-regular fa-user"></i> 계정 정보</h2>
            </div>
            
            <div class="cell">
                <h4>아이디</h4>
                <p>${memberDto.memberId}</p>
            </div>

            <div class="cell">
                <h4>닉네임</h4>
                <p>${memberDto.memberNickname}</p>
            </div>

            <div class="cell">
                <h4>이메일</h4>
                <p>${memberDto.memberEmail}</p>
            </div>

            <div class="cell">
                <h4>생년월일</h4>
                <p>${memberDto.memberBirth}</p>
            </div>

            <div class="cell">
                <h4>연락처</h4>
                <p>${memberDto.memberContact}</p>
            </div>

            <div class="cell">
                <h4>주소</h4>
                <p>${memberDto.memberPost}</p>
                <p>${memberDto.memberAddress1}</p>
                <p>${memberDto.memberAddress2}</p>
            </div>

            <div class="cell">
                <h4>등급</h4>
                <p>${memberDto.memberContact}</p>
            </div>

            <div class="cell">
                <h4>포인트</h4>
                <p>${memberDto.memberPoint} point</p>
            </div>
            
            <div class="cell">
                <h4>가입일시</h4>
                <p><fmt:formatDate value="${memberDto.memberJoin}" pattern="y년 M월 d일 a h시 m분 s초"/></p>
            </div>

            <div class="cell">
                <h4>최종로그인</h4>
                <p><fmt:formatDate value="${memberDto.memberLogin}" pattern="y년 M월 d일 a h시 m분 s초"/></p>
            </div>

            <div class="cell">
                <h4>비밀 번호 변경일</h4>
                <p><fmt:formatDate value="${memberDto.memberChange}" pattern="y년 M월 d일 a h시 m분 s초"/></p>
            </div>
            
         <hr>
         
		<div class="cell">
			<div class="cell">
			    <h2><i class="fa-solid fa-coins"></i> 포인트 구매 내역</h2>
			</div>

			<div class="cell">
			    <h4>구매 항목</h4>
			    <p>${purchaseHistoryDto.giftcardName}</p>
			</div>
			
			<div class="cell">
			    <h4>구매 일시</h4>
			    <p>${purchaseHistoryDto.giftcardPurchaseTime}</p>
			</div>
			
			<div class="cell">
			    <h4>구매 금액</h4>
			    <p>
			        ${purchaseHistoryDto.giftcardPrice}원 
			        x 
			        ${purchaseHistoryDto.giftcardPurchaseQty}개 
			        = 
			        ${purchaseHistoryDto.giftcardPurchaseTotal}원
			    </p>
			</div>
	</div>



<br><br>
<div class="cell center">
	<a href="password" class="btn btn-purple">비밀번호 변경</a>
	<a href="change" class="btn btn-pink">개인정보 변경</a>
	<a href="exit" class="btn btn-purple">회원 탈퇴</a>
</div>
<br><br>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>