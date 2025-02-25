<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2><i class="fa-solid fa-house-user"></i>&nbsp;My Info</h2>


<table border="1" width="400">
	<tr>
		<th width="25%">아이디</th>
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
			[${memberDto.memberPost}]
			${memberDto.memberAddress1}
			${memberDto.memberAddress2}
		</td>
	</tr>
	<tr>
		<th>등급</th>
		<td>${memberDto.memberLevel}</td>
	</tr>
	<tr>
		<th>포인트</th>
		<td>${memberDto.memberPoint} point</td>
	</tr>
	<tr>
		<th>가입일시</th>
		<td>
			<fmt:formatDate value="${memberDto.memberJoin}" 
										pattern="y년 M월 d일 a h시 m분 s초"/>
		</td>
	</tr>
	<tr>
		<th>최종로그인</th>
		<td>
			<fmt:formatDate value="${memberDto.memberLogin}" 
										pattern="y년 M월 d일 a h시 m분 s초"/>
		</td>
	</tr>
	<tr>
		<th>비밀번호<br>변경일</th>
		<td>
			<fmt:formatDate value="${memberDto.memberChange}" pattern="y년 M월 d일 a h시 m분 s초"/>
		</td>
	</tr>
</table>

<!-- 구매내역 출력 -->

<div class="container w-500">
        <div class="cell center">
            <h2><i class="fa-solid fa-credit-card"></i> 포인트 구매 내역</h2>
        </div>

        <div class="cell">
            <label><i class="fa-solid fa-check"></i> 구매 항목</label>
            
        </div>

        <div class="cell">
            <label><i class="fa-solid fa-check"></i> 구매 일시</label>
            ${purchaseHistoryDto.giftcardName}
            ${purchaseHistoryDto.giftcardPurchaseTime}
        </div>
        <div class="cell">
            <label><i class="fa-solid fa-check"></i> 구매 금액</label>
           	<span>
            	${purchaseHistoryDto.giftcardPrice}원 
				x 
				${purchaseHistoryDto.giftcardPurchaseQty}개 
				= 
				${purchaseHistoryDto.giftcardPurchaseTotal}원
            </span>
        </div>
    </div>

	<tbody>
		<c:forEach var="purchaseHistoryDto" items="${purchaseHistoryList}">
		<tr>
			<td>${purchaseHistoryDto.giftcardName}</td>
			<td>${purchaseHistoryDto.giftcardPurchaseTime}</td>
			<td>
				${purchaseHistoryDto.giftcardPrice}원 
				x 
				${purchaseHistoryDto.giftcardPurchaseQty}개 
				= 
				${purchaseHistoryDto.giftcardPurchaseTotal}원
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<br><br>
<div class="cell center">
<a href="password" class="btn btn-purple">비밀번호 변경</a>
<a href="change" class="btn btn-pink">개인정보 변경</a>
<a href="exit" class="btn btn-purple">회원 탈퇴</a>
</div>
<br><br>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>