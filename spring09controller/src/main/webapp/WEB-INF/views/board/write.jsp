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

<form action="write" method="post" autocomplete="off">
	<div class="container w-500">
	    <div class="cell">
	        <h2>게시글 작성</h2>
	    </div>
	    <div class="cell">
	        <input type="text" class="field w-100" name="boardTitle" placeholder="제목">
	    </div>
	    <div class="cell">
	        <textarea class="field w-100" name="boardContent" rows="15" placeholder="내용"></textarea>
	    </div>
	    <div class="cell mt-30 right">
	    	<button class="btn btn-neutral"><a href="list">게시글 목록</a></button>
	        <button class="btn btn-positive">작성 완료</button>
	    </div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>