<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>상품권 목록</h2>

<table width="500">
	<c:forEach var="giftcardDto" items="${list}">
	<tr>
		<th width="30%">이미지</th>
			<img src="image?giftcardNo=${giftcardDto.giftcardNo}" width="80%">
		<th>
			<h3>${giftcardDto.giftcardName}</h3>
			<h3>
				${giftcardDto.giftcardCharge}point
				(${giftcardDto.giftcardPrice}원,
				${giftcardDto.discountRate}% 할인)
			</h3>
			
			<a href="detail?giftcardNo=${giftcardDto.giftcardNo}">구매하기</a>
			
		</th>
	</tr>
	</c:forEach>
	
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>