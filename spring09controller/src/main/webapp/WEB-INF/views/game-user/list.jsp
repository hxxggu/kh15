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
            background-color: rgb(255, 255, 205);
        }
        
         .table.table-hover>tbody>tr:hover {
         	background-color: rgb(243, 243, 118);
        }
    </style>

<div class="container w-500">
	<div class="cell center">
    	<h2>[ 게임 유저 리스트 ]</h2>
	</div>
	<div class="cell right">
		<a href="/" class="btn btn-nuetral">Main</a>
		<a href="add" class="btn btn-nuetral">+신규유저등록</a>
	<!-- 검색창 -->
	<div class="cell center">
		<form action="list" method="get">
		    <select name="column">
				<option ${column=='아이디' ? 'selected' : ''}>아이디</option>
				<option  ${column=='직업' ? 'selected' : ''}>직업</option>
			</select>
			<input type="search" name="keyword" value="${keyword}">
			<button>검색</button>
		</form>
	</div>

<!-- 데이터 표시 영역 -->
	<div class="cell center">
	    <table class="table table-border table-stripe table-hover table-ellipsis">
			<thead>
				<tr>
				   <th>아이디</th>
				   <th>직업</th>
				   <th>레벨</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="gameUserDto" items="${list}">
				<tr>
					<td>
						<a href="detail?gameUserNo=${gameUserDto.gameUserNo}">
						${gameUserDto.gameUserId}
						</a>
					</td>
					<td>${gameUserDto.gameUserJob}</td>
					<td>${gameUserDto.gameUserLevel}</td>
				</tr>
				</c:forEach>
			</tbody>
	    </table>
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>