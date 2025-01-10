<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>국가 정보</h1>

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
</table>

<h2>
	<a href="add">신규등록</a>
	<a href="list">목록보기</a>
	<a href="edit?countryNo=${countryDto.countryNo}">수정하기</a>
	<a href="delete?countryNo=${countryDto.countryNo}">삭제하기</a>
</h2>