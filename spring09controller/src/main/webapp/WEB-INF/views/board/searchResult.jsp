<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h3>검색 결과</h3>
<form action="list" method="get">
	<table border="1" width="600">
		
		<thead>
			<tr>
				<th>NO.</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		
		<tbody align="center">
			<c:forEach var="gameUserDto" items="${list}">
			<tr>
				<td>${boardDto.boardNo}</td>
				<td>
					<a href="detail?boardNo=${boardDto.boardNo}">
						${boardDto.boardTitle}
					</a>
				</td>
				<td>${boardDto.boardTitle}</td>
				<td>${boardDto.boardWriter}</td>
				<td>${boardDto.boardWtime}</td>
			</tr>
			</c:forEach>		
		</tbody>
	</table>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>