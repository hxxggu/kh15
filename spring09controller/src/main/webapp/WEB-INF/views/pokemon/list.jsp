<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<c:if test="${sessionScope.userLevel == '관리자'}">
	<script type="text/javascript">
		$(function(){
			$(".form-delete").submit(function(){
				var checkItems = $(".check-item:checked");
				if(checkItems.length == 0) {
					window.alert("항목을 먼저 선택해야 합니다");
					return false;
				}
				
				return window.confirm("정말 삭제하시겠습니까?");
			});
		});
	</script>
</c:if>

<c:if test="${sessionScope.userLevel == '관리자'}">
	<!-- 전체 삭제를 위해 테이블 전체를 감싸는 form 생성 -->
	<form class="form-delete" action="deleteAll" method="post">
	</c:if>

    <div class="container w-500">
        <div class="cell center">
            <h2>[ Pokemon List ]</h2>
        </div>
        <div class="cell right">
        <c:if test="${sessionScope.userLevel == '관리자'}">
        	<button type="submit" class="btn btn-pink"><i class="fa-regular fa-trash-can"></i> 삭제</button>
        </c:if>
		<a href="add" class="btn btn-pink"><i class="fa-solid fa-plus"></i> 추가</a>
		<a href="/" class="btn btn-pink"><i class="fa-solid fa-house"></i></a>
        </div>
        <!-- 검색창 -->
		<div class="cell center">
		<form action="list" method="get">
	    	<select name="column" class="field">
					<option ${column=='이름' ? 'selected' : ''}>이름</option>
					<option  ${column=='속성' ? 'selected' : ''}>속성</option>
				</select>
				<input type="search" name="keyword" value="${keyword}" class="field">
				<button class="btn btn-purple">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</form>
		</div>
		
        <div class="cell center">
            <table class="table table-border table-stripe table-hover">
                <thead>
                    <tr>
                    	<c:if test="${sessionScope.userLevel == '관리자'}">
	                    	<th>
	                    		<input type="checkbox" class="check-all">
	                    	</th>
                    	</c:if>
                        <th>Image</th>
                        <th>No.</th>
                        <th>이름</th>
                        <th>속성</th>
                        <th><i class="fa-solid fa-heart-circle-check"></i></th>
                    </tr>
                </thead>

                <tbody class="center">
				<c:forEach var="pokemonDto" items="${list}">
					<tr>
						<c:if test="${sessionScope.userLevel == '관리자'}">
							<td>
								<input type="checkbox" class="check-item" name="pokemonNo" value="${pokemonDto.pokemonNo}">
							</td>
						</c:if>
						<td>
							<img src="image?pokemonNo=${pokemonDto.pokemonNo}" width="50" height="50">
						</td>
						<td>${pokemonDto.pokemonNo}</td>
						<td style="max-width:200px">
							<a href="detail?pokemonNo=${pokemonDto.pokemonNo}">
									${pokemonDto.pokemonName}
							</a>
						</td>
						<td>${pokemonDto.pokemonType}</td>
						<td>
							<c:if test="${pokemonDto.pokemonLike >= 0}">
								${pokemonDto.pokemonLike}
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>