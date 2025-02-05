<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="add" method="post" enctype="multipart/form-data" autocomplete="off">
	<div class="container w-400">
		<div class="cell center">
		    <h2>국가 정보 등록</h2>
		</div>
		<div class="cell center">
		    <label>국가 이름</label>
		    <input type="text" name="coutryName" class="field w-100" required>
		</div>
		<div class="cell center">
		    <label>수도</label>
		    <input type="text" name="countryCapital" class="field w-100" required>
		</div>
		<div class="cell center">
		    <label>인구 수</label>
		    <input type="text" name="countryPopulation" class="field w-100" required>
		</div>
		<div class="cell center">
		    <label>국기 이미지</label>
		    <input type="file" name="attach" class="field w-100">
		</div>
		<div class="cell center">
		    <button class="btn btn-positive field w-100">등록하기</button>
		</div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>