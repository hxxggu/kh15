<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>국가 등록</h1>

<form action="add" method="post">
	국가명 <input type="text" name="countryName"> <br><br>
	수도명 <input type="text" name="countryCapital"> <br><br>
	인구수 <input type="number" name="countryPopulation"> <br><br>
	<button>등록하기</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>