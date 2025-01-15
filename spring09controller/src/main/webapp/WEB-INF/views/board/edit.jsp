<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h3>게시글 수정</h3>

<form action="edit" method="post">
	<input type="hidden" name="boardNo" value="${boardDto.boardNo}">
	* 제목 <input type="text" name="boardTitle" value="${boardDto.boardTitle}" required><br><br>
	* 내용 <input type="text" name="boardContent" value="${boardDto.boardContent}" required><br><br>
	<button>수정</button>
</form>
	<button a href="/board/detail?${boardDto.boardNo}">취소</button>
     
    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>