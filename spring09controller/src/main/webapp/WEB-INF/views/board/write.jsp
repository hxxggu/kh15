<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>게시글 작성</h2>

<form action="write" method="post">
	<input type="text" name="boardTitle" style="width:440" placeholder="제목" required> <br><br>
	<textarea name="boardContent" required rows="10" cols="60" placeholder="내용" required></textarea>
	<br><br>
	<button>글쓰기</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>