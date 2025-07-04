<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<style>
	.table.table-ellipsis>tbody>tr>th,
	.table.table-ellipsis>tbody>tr>td {
	    overflow: hidden;
	    text-overflow: ellipsis;
	    white-space: nowrap;
	}

	.table {
	    width: 100%;
	    font-size: 16px;
	    font-weight: 400;
	    border-collapse: collapse;
	}

	.table.table-border,
	.table.table-border>thead>tr>th,
	.table.table-border>thead>tr>td,
	.table.table-border>tbody>tr>th,
	.table.table-border>tbody>tr>td,
	.table.table-border>tfoot>tr>th,
	.table.table-border>tfoot>tr>td {
	    border: 1px solid #636363;
	}
	.table>thead>tr>th,
	      .table>thead>tr>td,
	      .table>tbody>tr>th,
	      .table>tbody>tr>td,
	      .table>tfoot>tr>th,
	      .table>tfoot>tr>td {
	          padding: 0.25em;
	          font-weight: inherit;
	      }
     .table.table-stripe>thead,
     .table.table-stripe>tbody>tr:nth-child(2n) {
         background-color: #ffedfa;
     }
     
      .table.table-hover>tbody>tr:hover {
      	background-color: #ffddfd;
     }
</style>

<div class="container w-950">
	<div class="cell center">
		<h2><i class="fa-solid fa-paw"></i>&nbsp;&nbsp;자유 게시판&nbsp;&nbsp;<i class="fa-solid fa-paw"></i></h2>
		<p><b>글은 자신의 인격입니다.</b><br>(* 무분별한 비방 시 글이 삭제될 수 있습니다.)</p>
		
	<!-- 테이블 -->
	<div class="cell">
		<table class="table table-border table-hover table-ellipsis">
		<thead>
			<tr>
				<th>No.</th>
				<th width="width:450px; max-width:450px;">Title</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
		<!-- <th>좋아요</th>
				<th>그룹</th>
				<th>상위글</th>
				<th>차수</th>  -->
			</tr>
		</thead>
		<c:choose>
			<c:when test="${list.isEmpty()}">
				<tbody>
					<tr height="150">
						<td colspan="6" align="center">
							등록된 게시글이 없습니다
						</td>
					</tr>
				</tbody>
			</c:when>
			<c:otherwise>
				<tbody align="center">
					<c:forEach var="boardListViewDto" items="${list}">
					<tr>
						<td>${boardListViewDto.boardNo}</td>
						<td align="left">
						
							<!-- [멘션버전] 답글이라면 상위글 제목을 표시 -->
	<%-- 						<c:if test="${boardListViewDto.targetNo > 0}">
								<a href="detail?boardNo=${boardListViewDto.targetNo}">
									${boardListViewDto.targetTitle}
								</a>
								<br>
							</c:if> --%>
						
							<!-- 글의 차수(board_depth)에 따라 띄어쓰기 부여 -->
							<c:if test="${boardListViewDto.boardDepth > 0}">
								<c:forEach var="i" begin="1" end="${boardListViewDto.boardDepth}" step="1">
								&nbsp;&nbsp;
								</c:forEach>
									<i class="fa-solid fa-angles-right"></i>
							</c:if>
									
							<!-- 게시글 제목 -->
							&nbsp;
							<a href="detail?boardNo=${boardListViewDto.boardNo}">
								${boardListViewDto.boardTitle}
							</a>
							
							<!-- 댓글 표시 -->
							
							<c:if test="${boardListViewDto.boardReply > 0}">
								&nbsp;
<%--								[${boardListViewDto.boardReply}] --%>
								<span class="mt-10">
									<i class="fa-solid fa-comment-dots blue"></i>
									 ${boardListViewDto.boardReply}
								</span>
							</c:if>
							
							<!-- 좋아요 표시 -->
							<c:if test="${boardListViewDto.boardLike > 0}">
								&nbsp;
								<span>
									<i class="fa-solid fa-heart red"></i>
									 ${boardListViewDto.boardLike}
								</span>
							</c:if>
							
						</td>
						<td>
							<c:choose>
								<c:when test="${boardListViewDto.memberNickname == null}">
									탈퇴한 사용자
								</c:when>
								<c:otherwise>
									${boardListViewDto.memberNickname}
								</c:otherwise>
							</c:choose>
						</td>
	<%-- 				<td>${boardDto.getBoardWtimeString()}</td> --%>
						<td>${boardListViewDto.boardWtimeString}</td>
						<td>${boardListViewDto.boardRead}</td>
<%--						<td>${boardListViewDto.boardLike}</td>
						<td>${boardListViewDto.boardGroup}</td>
						<td>${boardListViewDto.boardTarget}</td>
						<td>${boardListViewDto.boardDepth}</td> --%>
					</tr>
					</c:forEach>
				</tbody>
			</c:otherwise>
		</c:choose>
	</table>
	</div>
	<div class="cell right">
		<a href="write" class="btn btn-pink">
			<i class="fa-regular fa-pen-to-square"></i> 글쓰기
		</a>
		<a href="/" class="btn btn-purple">
			<i class="fa-solid fa-house"></i>
		</a>
	</div>
	
	<!-- 페이지 네비게이터 -->
	<div class="cell center">
		<jsp:include page="/WEB-INF/views/template/pagination.jsp"></jsp:include>
	</div>
	
	<!-- 검색창 -->
		<div class="cell center">
			<form action="list" method="get">
				<select name="column" class="field">
					<option value="board_title" ${param.column == 'board_title' ? 'selected' : ''}>제목</option>
					<option value="board_writer" ${param.column == 'board_writer' ? 'selected' : ''}>작성자</option>
				</select>
				<input type="text" name="keyword" value="${param.keyword}" class="field">
				<button class="btn btn-purple">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</form>
		</div>
	</div>
	</div>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>