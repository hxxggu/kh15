<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="./commons.css">
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
<body>
	<div class="container w-700">
		<div class="cell center">
			<h2>[ Game User List ]</h2>
		</div>
		
		<div class="cell right">
			<a href="add" class="btn btn-pink"><i class="fa-solid fa-plus"></i> 추가</a>
			<a href="/" class="btn btn-pink"><i class="fa-solid fa-house"></i></a>
		</div>
		
		<!-- 검색창 -->
		<div class="cell center">
			<form action="list" method="get">
				<select name="column" class="field">
					<option ${column=='아이디' ? 'selected' : ''}>아이디</option>
					<option ${column=='직업' ? 'selected' : ''}>직업</option>
				</select>
				<input type="search" name="keyword" value="${keyword}" class="field">
				<button class="btn btn-purple">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</form>
		</div>
			
		<!-- 테이블 -->
		<div class="cell">
			<table class="table table-border table-stripe table-hover">
				<thead>
					<tr>
						<th>아이디</th>
						<th>직업</th>
						<th>레벨</th>
						<th>메뉴</th>
					</tr>
				</thead>
				<tbody class="center">
					<c:forEach var="gameUserDto" items="${list}">
					<tr>
						<td>${gameUserDto.gameUserId}</td>
						<td>${gameUserDto.gameUserJob}</td>
						<td>${gameUserDto.gameUserLevel}</td>
						<td>
							<a href="detail?gameUserNo=${gameUserDto.gameUserNo}">
								상세
							</a>
						</td>
					</tr>
					</c:forEach>		
				</tbody>
			</table>
		</div>
	</div>
</body>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>



