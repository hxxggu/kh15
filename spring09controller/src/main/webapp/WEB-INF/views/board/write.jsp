<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	이 페이지로 올 수 있는 방법
	1. 목록에서 '글쓰기'를 누르는 방법
	2. 상세에서 '글쓰기'를 누르는 방법
	3. 상세에서 '답글쓰기'를 누르는 방법 (boardTarget 파라미터 존재)
	- 이 경우는 글 등록 처리 페이지로 boardTarget을 전송해야 한다
	- 조건부로 input[type=hidden] 사용
 --%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>게시글 작성</h2>

<form action="write" method="post">
	<c:if test="${param.boardTarget != null}">
		<input type="hidden" name="boardTarget" value="${param.boardTarget}">
	</c:if>
	<input type="text" name="boardTitle" style="width:440" placeholder="제목" required> <br><br>
	<textarea name="boardContent" required rows="10" cols="60" placeholder="내용" required></textarea>
	<br><br>
	<button>글쓰기</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>