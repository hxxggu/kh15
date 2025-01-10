<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>포켓몬 등록</h1>

<!-- <form action="/pokemon/add2"> -->
<form action="add" method="post">
	몬스터 이름 <input name="pokemonName"> <br><br>
	몬스터 속성 <input name="pokemonType"> <br><br>
	<button>몬스터 등록</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>