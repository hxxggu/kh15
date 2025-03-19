<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- summernote cdn -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">
<style>
	.note-editor {
		border: 1px solid #636e72 !important;
	}
	.note-editable {
	    background-color: white !important;
	}
</style>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>
<script src="/js/summernote-custom.js"></script>


<h2><i class="fa-solid fa-pen-to-square"></i> 게시글 수정</h2>

<form action="edit" method="post" class="form-check">
	<input type="hidden" name="boardNo" value="${boardDto.boardNo}">
	<input type="text" name="boardTitle" value="${boardDto.boardTitle}" style="width:440" required> <br><br>
	<!-- textarea는 value가 없고 태그 사이에 입력값을 적는다(여러줄이라서) -->
	<textarea name="boardContent" rows="10" cols="60" required>${boardDto.boardContent}</textarea>
	<br><br>
	<button class="btn btn-pink"><i class="fa-solid fa-pen-to-square"></i>수정 완료</button>
</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>