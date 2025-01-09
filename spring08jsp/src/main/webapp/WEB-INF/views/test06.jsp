<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h1>선수 등록 화면</h1>


<form action="http://localhost:8080/player/add">
	선수명 <input type="text" name="playerName"><br><br>
	종목명 <input type="text" name="playerEvent"><br><br>
	구분
<!-- 
	참고 : 이름이랑 값이 같은 경우는 값(value)을 생략할 수 있다
	checked, seleted, required, readonly, disabled, ...
-->
	<select>
		<option value="하계">하계</option>
		<option value="동계">동계</option>
	</select>
<!--<input type="radio" name="plyerType" value="하계" checked="checked"> 하계 -->
<!--<input type="radio" name="plyerType" value="동계"> 동계 -->
	<br><br>
	금메달 <input type="number" name="playerGoldMedal"><br><br>
	금메달 <input type="number" name="playerSilverMedal"><br><br>
	금메달 <input type="number" name="playerBronzeMedal"><br><br>
	<button>선수 등록</button>
</form>

<hr>

<h1>강좌 등록 화면</h1>

<form action="/lecture/add">
	강좌명 <input type="text" name="lectureName" required><br><br>
	카테고리 <input type="text" name="lectureCategory" required><br><br>
	수업시간 <input type="number" name="lecturePriod"
				min="30" step="30" value="30" required><br><br>
	수강료 <input type="number" name="lecturePrice"
				min="0" step="1000" required><br><br>
	수업유형
	<select name="lectureType" required>
		<option> 선택하세요 </option>
		<option value="온라인"> 온라인 </option>
		<option value="오프라인"> 오프라인 </option>
		<option value="혼합"> 혼합 </option>
	</select>
	<br><br>
	<button>강좌 등록</button>
</form>








