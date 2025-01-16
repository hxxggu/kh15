<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>${boardDto.boardTitle}</h2>
<div>
	작성자 : <b>${boardDto.boardWriter}</b>
	<br>
	[ ${boardDto.boardWtime} ]
	[조회 : ${boardDto.boardRead}]
</div>

<hr>

<div style="min-height:200px">
	<pre>${boardDto.boardContent}</pre>
</div>

<hr>

<div>
	| 좋아요 <b>${boardDto.boardLike}</b> | 
	댓글 <b>${boardDto.boardReply}</b> |
</div>
<br>
<div>
	<button><a href="write">글쓰기</a></button>
	
	<!-- 소유자일 경우만 수정과 삭제를 표시 -->
	<c:if test="${sessionScope.userId != null}">
		<c:if test="${sessionScope.userId == boardDto.boardWriter}">
			<button><a href="edit?boardNo=${boardDto.boardNo}">수정</a></button>
			<button><a href="delete?boardNo=${boardDto.boardNo}">삭제</a></button>
		</c:if>
	</c:if>
	
	<button><a href="list">목록</a></button>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>