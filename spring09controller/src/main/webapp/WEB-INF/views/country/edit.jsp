<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>국가 정보 수정</h2>

<form action="edit" method="post" enctype="multipart/form-data">
	<input type="hidden" name="countryNo" value="${countryDto.countryNo}">
	*국가명 <input type="text" name="countryName" value="${countryDto.countryName}" required><br><br>
	*수도명 <input type="text" name="countryCapital" value="${countryDto.countryCapital}" required><br><br>
	*인구수 <input type="number" name="countryPopulation" value="${countryDto.countryPopulation}" required><br><br>
	국기 이미지 <input type="file" name="attach"><br><br>
	<small>*미설정 시 현상태 유지</small><br><br>
	<button>수정완료</button> 
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>