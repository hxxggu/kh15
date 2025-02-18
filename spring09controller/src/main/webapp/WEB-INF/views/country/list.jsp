<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <div class="container w-500">
        <div class="cell center">
            <h2>[ Country List ]</h2>
        </div>
        <div class="cell right">
			<a href="add" class="btn btn-pink"><i class="fa-solid fa-plus"></i> 추가</a>
			<a href="/" class="btn btn-pink"><i class="fa-solid fa-house"></i></a>
        </div>
        <div class="cell center">
            <form action="list" method="get">
                <select name="column" class="field">
                    <option ${column == '국가명' ? 'selected' : '' }>국가명</option>
                    <option ${column == '수도명' ? 'selected' : ''}>수도명</option>
                </select>
                <input type="search" name="keyword" value="${keyrword}" class="field">
                <button class="btn btn-purple">
                	<i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </form>
        </div>
        
        <div class="cell center">
            <table class="table table-border table-stripe table-hover table-ellipsis">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>국가</th>
                        <th>수도</th>
                        <th>인구</th>
                    </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${list.isEmpty()}">
                        <tr>
                            <td colspan="4">데이터가 존재하지 않습니다</td>
                        </tr>
                    </c:when>
			        <c:otherwise>
				    <c:forEach var="countryDto" items="${list}">
                            <tr>
                                <td>${countryDto.countryNo}</td>
                                <td>
                                    <a href="detail?countryNo=${countryDto.countryNo}">
                                    ${countryDto.countryName}
                                </td>
                                <td>${countryDto.countryCapital}</td>
                                <td align="right">
                                    <fmt:formatNumber pattern="#,##0" 
                                        value="${countryDto.countryPopulation}"></fmt:formatNumber>
                                </td>
                            </tr>
                        </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>
    </div>
</body>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>