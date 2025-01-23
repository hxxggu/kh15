<%--
	JSP directive(설정 코드)
	- page, include, taglib에 대한 설정을 수행할 수 있는 코드
	- page :: 현재 페이지에 대한 기본 설정
		- language : 페이지에서 사용할 프로그래밍 언어 (java 밖에 안됨)
		- contentType : 현재 페이지의 유형(MIME-TYPE) >> type을 변경 시 다른 기능을 하지만 그런 식으로 사용자의 사용에 제한을 두지 X, 사용의 제한은 controller
		- pageEncoding : 내부적으로 JSP가 변환될 때 적용할 방식
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 정적/동적 include의 차이 : 정적 include는 코드를 먼저 합치고나서 변환
동적 include는 변환을 먼저하고 결과를 합침 --%>

<%-- 정적 include --%>
<%-- <%@ include file="/WEB-INF/views/template/header.jsp" %> --%>

<%-- 동적 include --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- 해당 선을 기준으로 상단부는 JSP 코드, 하단부는 HTML 코드 -->

<!--
	HTML 코드
	- <!DocType html>은 HTML의 형태를 선언하기 위한 표식
		- 현재 세계 표준은 HTML 5 (출시 후 10년 다 되어감)
		-  그 전에는 4, 4.1, 3, ... 등이 사용
	- <html>은 HTML 문서의 범위를 지정
		- <head>는 이 문서의 정보를 저장(편지봉투)
			- <meta>는 외부에 노출되는 문서의 정보 및 설정
				- url을 적었을 때, 자동으로 뜨는 이미지도 meta에서 설정 / (open graph)라고 함
			- <title>은 브라우저 탭에 표시될 페이지의 제목
		- <body>는 이 문서의 표시될 내용을 저장(편지지)
 -->
		<h2>♥ℍ𝔸ℙℙ𝕐♥</h2>
		<a href="/">
			<img src="/images/멍멍개.jpg" width="300" height="400">
		</a>
		
<%-- 정적 include --%>
<%--<%@ include file="/WEB-INF/views/template/footer.jsp" %> --%>

<%-- 동적 include --%>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>


