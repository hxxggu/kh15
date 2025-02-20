<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<c:if test="${sessionScope.userId != null }">
<!-- 좋아요 처리 관련 스크립트 (회원만) -->
<script type="text/javascript">
	$(function(){
		// 자바 스크립트에서 파라미터를 읽기 위한 방법
		var params = new URLSearchParams(location.search)
		var boardNo = params.get("boardNo"); // 파라미터에 있는 boardNo 의 값
		
		// 시작하자마자 좋아요 여부를 체크하여 결과를 표시
		$.ajax({
			url:"/rest/board/check",
			method:"post",
			data: {boardNo : boardNo},
			success:function(response) {//response에는 done, count가 있다
				$(".fa-heart").removeClass("fa-solid fa-regular")
					.addClass(response.done ? "fa-solid" : "fa-regular");
				$(".heart-count").text(response.count);
			}
		});
		
		// 하트를 클릭하면 좋아요 설정 / 해제를 구현
		$(".fa-heart").click(function(){
			$.ajax({
				url:"/rest/board/action",
				method:"post",
				data: {boardNo : boardNo},
				success:function(response) {//response에는 done, count가 있다
					$(".fa-heart").removeClass("fa-solid fa-regular")
						.addClass(response.done ? "fa-solid" : "fa-regular");
					$(".heart-count").text(response.count);
				}
			});
		});
	});
	
</script>
</c:if>

<!-- 댓글 관련 스크립트 -->
<script type="text/javascript">
	$(function(){
		// 글 번호 읽기
		var params = ;
		var boardNo = ;'
		
		// 최초 1회 목록을 불러오도록 처리
		loadList();
		
		// 목록을 불러오는 함수
		function loadList() {
			$.ajax({
				url : "/rest/reply/list",
				method : "post",
				data : { replyOrigin : boardNo },
				success : function(response){
					console.log(response);
				}
			})
		}
	});
</script>


<h2>${boardDto.boardTitle}</h2>
<div>
<%--${boardDto.boardWriter}--%>
	${memberDto.memberNickname}
	(${memberDto.memberLevel})<br>
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
	<i class="fa-heart fa-regular red"></i> 좋아요 <b>${boardDto.boardLike}</b> /  
	<i class="fa-regular fa-comment-dots"></i> 댓글 <b>${boardDto.boardReply}</b>
</div>
<br>
<div class="cell">
	<a href="write" class="btn btn-pink"><i class="fa-solid fa-pen"></i> 글쓰기</a>
	<a href="write?boardTarget=${boardDto.boardNo}" class="btn btn-purple"><i class="fa-solid fa-pen"></i> 답글쓰기</a>
	
	<!-- 소유자일 경우만 수정과 삭제를 표시 -->
	<c:if test="${sessionScope.userId != null}">
		<c:if test="${sessionScope.userId == boardDto.boardWriter}">
			<a href="edit?boardNo=${boardDto.boardNo}"  class="btn btn-pink"><i class="fa-solid fa-pen-to-square"></i> 수정</a>
			<a href="delete?boardNo=${boardDto.boardNo}"  class="btn btn-purple"><i class="fa-solid fa-trash-can"></i> 삭제</a>
		</c:if>
	</c:if>
	
	<a href="list" class="btn btn-pink"><i class="fa-solid fa-list-ul"></i> 목록</a>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>