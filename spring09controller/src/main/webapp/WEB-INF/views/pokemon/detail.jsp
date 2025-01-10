<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>[${pokemonDto.pokemonName}] 몬스터 정보</h1>

<table border="1" width="300">
	<tr>
		<th width="30%">번호</th>
		<td>${pokemonDto.pokemonNo}</td>
	</tr>
	
	<tr>
		<th>이름</th>
		<td>${pokemonDto.pokemonName}</td>
	</tr>
	
	<tr>
		<th>속성</th>
		<td>${pokemonDto.pokemonType}</td>
	</tr>
</table>

<h2>
	<a href="add">신규등록</a>
	<a href="list">목록보기</a>
	<a href="#">수정하기</a>
	<a href="#">삭제하기</a>
</h2>