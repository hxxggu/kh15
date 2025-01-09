<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>국가 목록</h1>

<!-- 검색창 - /country/list?column=국가명&keyword=한국 -->
<form action="list" method="get">
	<select name="column">
		<option>국가명
		<option ${column.equals('수도명')?'selected':"}>수도명
	</select>
	<input type="text" name="keyword" value="${keyword}" required>
	<button>검색</button>
</form>

<!-- for(CountryDto countryDto : list) { -->
<c:forEach var="countryDto" items="${list}">
	<h2>
		번호 : ${countryDto.countryNo},
		이름 : ${countryDto.countryName},
		수도 : ${countryDto.countryCapital},
		인구수 : ${countryDto.countryPopulation}
	</h2>
</c:forEach>