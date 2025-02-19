<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-400">

	<div class="cell">
		<h2><i class="fa-solid fa-angles-right"></i> ${pokemonDto.pokemonName}</h2>		
	</div>
	<div class="cell center">
		<img src="image?pokemonNo=${pokemonDto.pokemonNo}" width="300"> <!-- 동적 -->		
	</div>
	<div class="cell">
		<b><label>No.</label></b>
		${pokemonDto.pokemonNo}
	</div>
	
	<div class="cell">
		<b><label>이름</label></b>
		${pokemonDto.pokemonName}
	</div>
	
	<div class="cell">
		<b><label style="width: 40%">속성</label></b>
		${pokemonDto.pokemonType}
	</div>
	
	<div class="cell center">
		<a href="add" class="btn btn-pink p-25">신규등록</a>
		<a href="list" class="btn btn-purple p-25">목록보기</a>
		<a href="edit?pokemonNo=${pokemonDto.pokemonNo}" class="btn btn-pink p-25">수정하기</a>
		<a href="delete?pokemonNo=${pokemonDto.pokemonNo}" class="btn btn-purple p-25">삭제하기</a>
	</div>
</div>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>