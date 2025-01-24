<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>상품권 정보</h2>

<img src="image?giftcardNo=${giftcardDto.giftcardNo}" width="300">

<h3>${giftcardDto.giftcardName}</h3>

<p>
	${giftcardDto.giftcardCharge}point
	( ${giftcardDto.giftcardPrice}원, 
	${giftcardDto.discountRate}% 할인)
</p>

<pre>${giftcardDto.giftcardContent}</pre>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>