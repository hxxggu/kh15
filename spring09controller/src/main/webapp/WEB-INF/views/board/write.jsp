<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h3>[ 게시글 작성 ]</h3>

<form action="write" method="post">
	* 제목 <input type="text" name="board_title" style="width: 400" placeholder="제목을 입력하세요" required><br><br>
	* 내용 <input type="text" name="board_content" style="width: 400" placeholder="내용을 입력하세요" required><br><br>
	<button>작성완료</button>	
</form>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>