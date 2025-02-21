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
		var pokemonNo = params.get("pokemonNo"); // 파라미터에 있는 pokemonNo 의 값
		
		// 시작하자마자 좋아요 여부를 체크하여 결과를 표시
		$.ajax({
			url:"/rest/pokemon/check",
			method:"post",
			data: {pokemonNo : pokemonNo},
			success:function(response) {//response에는 done, count가 있다
				$(".fa-heart").removeClass("fa-solid fa-regular")
					.addClass(response.done ? "fa-solid" : "fa-regular");
				$(".heart-count").text(response.count);
			}
		});
		
		// 하트를 클릭하면 좋아요 설정 / 해제를 구현
		$(".fa-heart").click(function(){
			$.ajax({
				url:"/rest/pokemon/action",
				method:"post",
				data: {pokemonNo : pokemonNo},
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

<div class="container w-400">

	<div class="cell">
		<div class="cell left">
			<h2><i class="fa-solid fa-angles-right"></i> ${pokemonDto.pokemonName}</h2>
			<i class="fa-heart fa-regular red"></i> <b class="heart-count">${pokemonDto.pokemonLike}</b>
		</div>
	</div>
	<div class="cell center">
		<img src="image?pokemonNo=${pokemonDto.pokemonNo}" width="300"> <!-- 동적 -->		
	</div>
	<div class="cell w-100">
		<label class="cell"><b>No.</b></label>
		${pokemonDto.pokemonNo}
	</div>
	
	<div class="cell">
		<label><b>이름</b></label>${pokemonDto.pokemonName}
	</div>
	
	<div class="cell">
		<b><label style="width: 40%">속성</label></b>
		${pokemonDto.pokemonType}
	</div>
	
	<div class="cell">

	</div>
	
	<div class="cell center">
		<a href="add" class="btn btn-pink p-25">신규등록</a>
		<a href="list" class="btn btn-purple p-25">목록보기</a>
		<a href="edit?pokemonNo=${pokemonDto.pokemonNo}" class="btn btn-pink p-25">수정하기</a>
		<a href="delete?pokemonNo=${pokemonDto.pokemonNo}" class="btn btn-purple p-25">삭제하기</a>
	</div>
</div>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>