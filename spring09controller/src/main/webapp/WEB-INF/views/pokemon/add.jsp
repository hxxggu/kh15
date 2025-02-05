<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- <form action="/pokemon/add2"> -->
<!-- <form action ="add" method="post"> -->

<form action="add" method="post" enctype="multipart/form-data" autocomplete="off">
	<div class="container w-300">    
		<div class="cell center">
		    <h2>포켓몬 등록</h2>
		</div>
		<div class="cell center">
		    <label>포켓몬 이름</label>
		    <input type="text" name="pokemonName" class="field w-100" required>
		</div>		
		<div class="cell center">
	    <label>포켓몬 속성</label>
	    <select name="pokemonType" required class="field w-100">
		        <option value="">선택하세요</option>
		        <option>불</option>
		        <option>물</option>
		        <option>풀</option>
		        <option>땅</option>
		        <option>바람</option>
		        <option>전기</option>
		        <option>곤충</option>
		        <option>독</option>
		        <option>무속성</option>
		    </select>
		</div>
		<div clsss="cell center">
		    <label>이미지</label>
		    <input type="file" name="attach" class="field w-100">
		</div>
		<div class="cell center">
		    <button type="submit" class="btn btn-positive w-100">등록하기</button>
		</div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>