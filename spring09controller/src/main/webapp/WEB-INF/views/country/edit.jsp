<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>국가 정보 수정</h1>

<form action="edit" method="post">
	<input type="hidden" name="countryNo" value="${countryDto.countryNo}"> <!-- 수정하기 위해 필수적으로 있어야 함 -->
	국가명 <input type="text" name="countryName" value="${countryDto.countryName}" required><br><br>
	수도명 <input type="text" name="countryCapital" value="${countryDto.countryCapital}" required><br><br>
	인구수 <input type="number" name="countryPopulation" value="${countryDto.countryPopulation}" required><br><br>
	<button>수정</button> 
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>