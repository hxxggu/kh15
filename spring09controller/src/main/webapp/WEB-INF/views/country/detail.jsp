<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>국가 정보</h2>

<img src="image?countryNo=${countryDto.countryNo}" width="300">

<table border="1" width="300">
	<tr>
		<th width="30%">국가명</th>
		<td>${countryDto.countryName}</td>
	</tr>
	<tr>
		<th>수도</th>
		<td>${countryDto.countryCapital}</td>
	</tr>
	<tr>
		<th>인구수</th>
		<td>
			<fmt:formatNumber pattern="#,##0" 
				value="${countryDto.countryPopulation}">
			</fmt:formatNumber>명
		</td>
	</tr>
</table>

<br>

<div>
	<button><a href="add">신규등록</a></button>
	<button><a href="list">목록보기</a></button>
	<button><a href="edit?countryNo=${countryDto.countryNo}">수정하기</a></button>
	<button><a href="delete?countryNo=${countryDto.countryNo}">삭제하기</a></button>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>