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

<form action="write" method="post" autocomplete="off">
	<c:if test="${param.boardTarget != null}">
		<input type="hidden" name="boardTarget" value="${param.boardTarget}">
	</c:if>
	
	
	<div class="container w-500">
	    <div class="cell">
	        <h2>게시글 작성</h2>
	    </div>
	    
	    <div class="cell">
	        <input type="text" class="field w-100" name="boardTitle" placeholder="제목">
	    </div>
	    
	    <div class="cell">
	        <textarea class="field w-100" name="boardContent" placeholder="내용"></textarea>
	    </div>
	    
	    <div class="cell mt-30 right">
	    	<a href="list" class="btn btn-neutral">게시글 목록</a>
	        <button type="submit" class="btn btn-positive">작성 완료</button>
	    </div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>