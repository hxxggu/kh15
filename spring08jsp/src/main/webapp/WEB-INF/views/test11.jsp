<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>전달된 포켓몬 정보</h1>
<h2> 번호: ${list.get(0).pokemonNo} </h2>
<h2> 이름: ${list.get(0).pokemonName} </h2>
<h2> 속성: ${list.get(0).pokemonType} </h2>
<h2> 번호: ${list.get(1).pokemonNo} </h2>
<h2> 이름: ${list.get(1).pokemonName} </h2>
<h2> 속성: ${list.get(1).pokemonType} </h2>

<hr>

<%
	List<PokemonDto> list = pageContext.getAttribute("list");
	for(int i=0; i<list.size(); i++) {
%>		
		<h2>번호: <%=list.get(i).getPokemonNo()%></h2>
		<h2>이름: <%=list.get(i).getPokemonName()%></h2>
		<h2>속성: <%=list.get(i).getPokemonType()%></h2>
<%} %>



<hr>
<!-- 
	JSTL(Jsp Standard Tag Library)
	: 사용자가 보는 화면에서 조건, 반복 등 간단한 프로그래밍이 필요한 경우 사용
	: EL은 값을 지정해서 보여주는 것만 가능하므로 부족한 부분을 보충
	: 종류가 다양하지만 실제로 쓰는건 조건, 반복, 날짜/숫자 형식 정도만 사용
	: 사용하고 싶을 때 사용하겠다고 설정을 해야 함
 -->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 
<!-- for(PokemonDto pokemonDto : list){ -->
<c:forEach var="pokemonDto" items="${list}"> <!-- var=variable::변수 의미 -->
	<H2>번호 : ${pokemonDto.pokemonNo}</H2>
	<H2>이름 : ${pokemonDto.pokemonName}</H2>
	<H2>속성 : ${pokemonDto.pokemonType}</H2>
</c:forEach>
 
 
 
 
 