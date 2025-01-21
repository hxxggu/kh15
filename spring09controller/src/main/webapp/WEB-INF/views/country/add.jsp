<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>국가 등록</h2>

<form action="add" method="post" enctype="multipart/form-data">
	<h5 style="color:red">(*필수입력항목)</h5>
	*국가명 <input type="text" name="countryName"> <br><br>
	*수도명 <input type="text" name="countryCapital"> <br><br>
	*인구수 <input type="number" name="countryPopulation"> <br><br>
	국기 <input type="file" name="attach" accept=".png, .jpg"><br><br>
	<button>등록하기</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>