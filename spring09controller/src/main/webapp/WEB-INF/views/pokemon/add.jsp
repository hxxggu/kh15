<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>포켓몬 등록</h2>

<!-- <form action="/pokemon/add2"> -->
<!-- <form action ="add" method="post"> -->

<form action="add" method="post" enctype="multipart/form-data">
	포켓몬 이름 <input name="pokemonName"> <br><br>
	포켓몬 속성 <input name="pokemonType"> <br><br>
	포켓몬 이미지 <input type="file" name="attach"><br><br>
	<button>등록</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>