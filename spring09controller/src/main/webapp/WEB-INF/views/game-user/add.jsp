<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="add" method="post" enctype="multipart/form-data">
	<div class="container w-500">
        <div class="cell center">
            <h1>게임 유저 등록</h1>
        </div>
        <div class="cell">
            <label>아이디 <span class="red">*</span></label>
            <input type="text" name="gameUserId" required placeholder="(ex) 이순신" class="field w-100">
        </div>    
        <div class="cell">
            <label>직업 <span class="red">*</span></label>
            <select name="gameUserJob" required class="field w-100">
                <option value="">선택</option>
                <option>전사</option>
                <option>성직자</option>
                <option>도적</option>
            </select>
        </div>
        
        <%-- 관리자만 레벨과 골드 설정이 가능하게 구현 --%>
        <c:if test="${sessionScope.userLevel == '관리자'}">
        <div class="cell">
            <label>레벨</label>
            <input type="number" name="gameUserLevel" class="field w-100" value="1" min="1">
        </div>
        <div class="cell">
            <label>소지골드</label>
            <input type="number" name="gameUserMoney" class="field w-100" value="0" min="0">
        </div>
        </c:if>
        
        <div class="cell">
            <label>프로필 이미지</label>
            <input type="file" name="attach" accept=".png">
        </div>
        <div class="cell mt-30">
            <button type="submit" class="btn btn-positive w-100">등록하기</button>
        </div>
    </div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>