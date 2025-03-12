<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-900">
	<div class="cell">
		<h2><i class="fa-solid fa-user-tie"></i> 관리자 홈</h2>
	</div>
	<div class="cell">
		<label><i class="fa-solid fa-asterisk"></i> 데이터 관리</label>
		<div class="cell">
			<a href="/admin/member/list" class="btn btn-pink" style="border-radius: 10px;">회원 관리</a>
			<a href="/admin/giftcard/add" class="btn btn-purple" style="border-radius: 10px;">상품권 등록</a>
			<a href="/admin/giftcard/list" class="btn btn-pink" style="border-radius: 10px;">상품권 관리</a>
		</div>
	</div>
	<div class="cell">
		<label><i class="fa-solid fa-asterisk"></i> 데이터 현황</label>
		<div class="cell">
			<a href="/admin/status/pokemon" class="btn btn-pink" style="border-radius: 10px;">포켓몬 현황</a>
			<a href="/admin/status/game-user" class="btn btn-purple" style="border-radius: 10px;">게임유저 현황</a>
			<a href="/admin/status/member" class="btn btn-pink" style="border-radius: 10px;">회원 현황</a>
			<a href="/admin/status/member-join" class="btn btn-purple" style="border-radius: 10px;">회원가입 현황</a>
			<a href="/admin/status/board-write" class="btn btn-pink" style="border-radius: 10px;">게시글 작성 현황</a>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>