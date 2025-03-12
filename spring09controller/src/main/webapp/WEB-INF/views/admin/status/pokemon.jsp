<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-800">
	<div class="cell">
		<h2><i class="fa-solid fa-angles-right"></i> 포켓몬스터 속성별 개체 수</h2>
	</div>
	<div class="cell">
		<c:forEach var="statusVO" items="${list }">
			<b>${statusVO.key}</b> &nbsp; ${statusVO.value}<br>
			<hr style="">
		</c:forEach>
	</div>
	<div class="cell">
		<a href="/admin/home" class="btn btn-pink"><i class="fa-solid fa-user-tie black"></i> 관리자 홈</a>
		<a href="/" class="btn btn-purple"><i class="fa-solid fa-house"></i> 메인</a>
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>