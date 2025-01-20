<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>자유 게시판</h2>
<p>글은 자신의 인격입니다.<br>(*무분별한 비방 시 글이 삭제될 수 있습니다.)</p>

<button><a href="write">글쓰기</a></button><br><br>

<!-- 테이블 -->
<table border="1" width="800">
	<thead>
		<tr>
			<th>번호</th>
			<th width="45%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>좋아요</th>
			<th>그룹</th>
			<th>상위글</th>
			<th>차수</th>
		</tr>
	</thead>
	<c:choose>
		<c:when test="${list.isEmpty()}">
			<tbody>
				<tr height="150">
					<td colspan="6" align="center">
						등록된 게시글이 없습니다
					</td>
				</tr>
			</tbody>
		</c:when>
		<c:otherwise>
			<tbody align="center">
				<c:forEach var="boardDto" items="${list}">
				<tr>
					<td>${boardDto.boardNo}</td>
					<td align="left">
						<!-- 글의 차수(board_depth)에 따라 띄어쓰기 부여 -->
						<c:if test="${boardDto.boardDepth > 0}">
							<c:forEach var="i" begin="1" end="${boardDto.boardDepth}" step="1">
								&nbsp;&nbsp;
							</c:forEach>
							→
						</c:if>
								
						<!-- 게시글 제목 -->
						<a href="detail?boardNo=${boardDto.boardNo}">
							${boardDto.boardTitle}
						</a>
						
						<!-- 댓글 표시 -->
						<c:if test="${boardDto.boardReply > 0}">
						[${boardDto.boardReply}]
						</c:if>
					</td>
					<td>${boardDto.boardWriter}</td>
<%-- 					<td>${boardDto.getBoardWtimeString()}</td> --%>
					<td>${boardDto.boardWtimeString}</td>
					<td>${boardDto.boardRead}</td>
					<td>${boardDto.boardLike}</td>
					<td>${boardDto.boardGroup}</td>
					<td>${boardDto.boardTarget}</td>
					<td>${boardDto.boardDepth}</td>
				</tr>
				</c:forEach>
			</tbody>
		</c:otherwise>
	</c:choose>
</table>

<!-- 페이지 네비게이터 -->
<jsp:include page="/WEB-INF/views/template/pagination.jsp"></jsp:include>

<!-- 검색창 -->
<form action="list" method="get">
	<select name="column">
		<option value="board_title" ${param.column == 'board_title' ? 'selected' : ''}>제목</option>
		<option value="board_writer" ${param.column == 'board_writer' ? 'selected' : ''}>작성자</option>
	</select>
	<input type="text" name="keyword" value="${param.keyword}">
	<button>검색</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>