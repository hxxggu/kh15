<%--
	JSP directive (설정 코드)
	- page, include, taglib에 대한 설정을 수행할 수 있는 코드
	- page : 현재 페이지에 대한 기본 설정
		- language : 페이지에서 사용할 프로그래밍 언어(java밖에 안됨)
		- contentType : 현재 페이지의 유형(MIME-TYPE)
		- pageEncoding : 내부적으로 JSP가 변환될 때 적용할 방식
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--정적 include --%>
<%-- <%@ include file="/WEB-INF/views/template/header.jsp" %> --%>

<%-- 동적 include --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-950">
	<div class="cell center">
		<h2>
			<i class="fa-solid fa-dog"></i>
			<i class="fa-solid fa-bone"></i>
			<i class="fa-solid fa-paw"></i>
		</h2>
	</div>
	
	<div class="cell center">
		<img src="./images/해피.jpg" width="500px">
	</div>
</div>


<%-- 정적 include --%>
<%-- <%@ include file="/WEB-INF/views/template/footer.jsp" %> --%>

<%-- 동적 include --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
