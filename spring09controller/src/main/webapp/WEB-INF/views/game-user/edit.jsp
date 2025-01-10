<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>사용자 정보 수정</h1>
<form action="edit" method="post">
	<input type="hidden" name="gameUserNo" value="${gameUserDto.gameUserNo}">
	ID <input type="text" name="gameUserId" value="${gameUserDto.gameUserId}"><br><br>
	직업 <input type="text" name="gameUserJob" value="${gameUserDto.gameUserJob}"><br><br>
	레벨 <input type="number" name="gameUserLevel" value="${gameUserDto.gameUserLevel}"><br><br>
	소지금 <input type="number" name="gameUserMoney" value="${gameUserDto.gameUserMoney}"><br><br>
	<button>정보수정</button>
</form>