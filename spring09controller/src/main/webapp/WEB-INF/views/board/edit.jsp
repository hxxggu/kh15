<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>게시글 수정</h2>

<form action="edit" method="post">
	<input type="hidden" name="boardNo" value="${boardDto.boardNo}">
	<input type="text" name="boardTitle" value="${boardDto.boardTitle}" style="width:440" required> <br><br>
	<!-- textarea는 value가 없고 태그 사이에 입력값을 적는다(여러줄이라서) -->
	<textarea name="boardContent" rows="10" cols="60" required>${boardDto.boardContent}</textarea>
	<br><br>
	<button>수정 완료</button>
</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>