<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<c:if test="${search == true}">
	<h2>국가 검색</h2>
</c:if>
<c:if test="${search == false}">
	<h2>국가 목록</h2>
</c:if>

<button><a href="add">신규 국가 등록</a></button>
<button><a href="/">메인화면</a></button><br><br>

<!-- 검색창 - /country/list?column=국가명&keyword=한국 -->
<form action="list" method="get">
	<select name="column">
		<option ${column == '국가명' ? 'selected' : '' }>국가명</option>
		<option ${column == '수도명' ? 'selected' : ''}>수도명</option>
	</select>
	<input type="text" name="keyword" value="${keyword}" required>
	<button>검색</button>
</form>

<table border="1" width="500">
	<thead>
		<tr>
			<th>국기</th>
			<th>번호</th>
			<th>국가</th>
			<th>수도</th>
			<th>인구</th>
		</tr>
	</thead>
	<tbody align="center">
		<c:choose>
			<c:when test="${list.isEmpty()}">
				<tr>
					<td colspan="4">데이터가 존재하지 않습니다</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="countryDto" items="${list}">
				<tr>
					<td>
						<img src="flag?countryNo=${countryDto.countryNo}" width="50" height="30">
					</td>
					<td>${countryDto.countryNo}</td>
					<td>
						<a href="detail?countryNo=${countryDto.countryNo}">
							${countryDto.countryName}
						</a>
					</td>
					<td>${countryDto.countryCapital}</td>
					<td align="right">
						<fmt:formatNumber pattern="#,##0" 
							value="${countryDto.countryPopulation}"></fmt:formatNumber>
					</td>
				</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>