<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>포켓몬 목록</h1>
<h2><a href="add">신규등록</a></h2>

<table border="1" width="400">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>속성</th>
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="pokemonDto" items="${list}">
		<tr>
			<td>${pokemonDto.pokemonNo}</td>
			<td>
				<a href="detail?pokemonNo=${pokemonDto.pokemonNo}">
					${pokemonDto.pokemonName}
				</a>
			</td>
			<td>${pokemonDto.pokemonType}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>