<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>게시글 목록</h2>

<table border="1" width="600">
	<thead>
		<tr>
			<th width="40">No.</th>
			<th width="400">제목</th>
			<th width="100">작성자</th>
			<th width="150">작성일자</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="boardDto" items="${list}">
			<tr>
				<td align="center">
					${boardDto.boardNo}
				</td>
				<td align="left">
					<a href="detail?boardNo=${boardDto.boardNo}">
						${boardDto.boardTitle}
					</a>
				</td>
				<td align="center">${boardDto.boardWriter}</td>
				<td align="center">${boardDto.boardWTime}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<br><br>

<form action="list" method="get">
	<select name="column">
		<option ${column=='제목' ? 'selected' : ''}>제목</option>
		<option ${column=='작성자' ? 'selected' : ''}>작성자</option>
	</select>
		<input type="text" name="keyword" value="${keyword}">	
		<button h4>검색</button>
		
		<button h4><a href="/board/write">글쓰기</a></button>
		<button h4><a href="/">메인</a></button>
		
</form>

<c:if test="${param.error != null}">
	<h4 style="color:red">해당 게시물이 존재하지 않습니다</h3>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>