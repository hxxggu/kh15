<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>게시글 정보</h2>

<table border="1" width="600">

	<tr>
		<td><b>[제목] ${boardDto.boardTitle}</b></th>
	</tr>
	<tr>
		<td><b>작성자:${boardDto.boardWriter}</b></th>
	</tr>
	<tr>
		<td><b>작성일:${boardDto.boardWtime}</b></td>
	</tr>
	<br><br>
	<tr>
		<td><b>내용</b></td><br>
		<td>${boardDto.boardContent}</td>
	</tr>

</table>

<h3>
	<button a href="/board/write">글쓰기</button>
	<button a href="/board/edit">수정</button>
	<button a href="/board/delete">삭제</button>
	<button a href="/board/list">목록</button>
</h3>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>