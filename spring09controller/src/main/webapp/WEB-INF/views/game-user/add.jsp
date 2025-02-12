<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<!-- 자바 스크립트 작성 공간 -->
<script type="text/javascript">
    function checkUserLevelInput() {
        var target = document.querySelector("[name = gameUserLevel]");
        var convert = target.value.replace(/[^0-9]+/g, "");
        convert = parseInt(convert); //숫자로 변환, 바꿔지지 않는다면 NaN
        // if(convert == NaN) //불가능한 조건
        if(isNaN(convert) || convert < 1) { //NaN 검사
            convert = 1;
        }
        target.value = convert;
    }

    function checkUserMoneyInput() {
        var target = document.querySelector("[name = gameUserMoney]");
        var convert = target.value.replace(/[^0-9]+/g, "");
    }
    
    function checkUserIdInput(){
        var target = document.querySelector("[name = gameUserId]");
        var regex = /[^A-Za-z0-9가-힣ㄱ-ㅎㅏ-ㅣ]/g;
        target.value = target.value.replace(regex, "");
    }

    function checkUserId(){
        var target =document.querySelector("[name = gameUserId]");
        var regex = /^[가-힣a-z0-9]{1,8}$/;
        var isValid = regex.test(target.value);
        target.classList.remove("success", "fail");
        target.classList.add(isValid ? "success" : "fail");
        return isValid;
    }

    function checkUserJob() {
        var target = document.querySelector("[name = gameUserJob]");
        var isValid = target.value.length > 0;
        target.classList.remove("success", "fail");
        target.classList.add(isValid ?  "success" : "fail");
        return isValid;
    }

    function checkUserLevel() {
        var target = document.querySelector("[name = gameUserLevel]");
        var number = parseInt(target.value);
        var isValid = !isNaN(number) && number > 0;
        target.classList.remove("success", "fail");
        target.classList.add(isValid ? "success" : "fail");
        return isValid;
    }

    function checkUserMoney() {
        var target = document.querySelector("[name = gameUserMoney]");
        var number = parseInt(target.value);
        var isValid = !isNaN(number) && number >= 0;
        target.classList.remove("success", "fail");
        target.classList.add(isValid ? "success" : "fail");
        return isValid;
    }

    function checkForm() {
        var valid1 = checkUserId();
        var valid2 = checkUserJob();
        var valid3 = checkUserLevel();
        var valid4 = checkUserMoney();

        return valid1 && valid2 && valid3 && valid4;
    }
</script>

<body>
<form action="add" method="post" enctype="multipart/form-data" autocomplete="off"
    onsubmit="return checkForm();">
	<div class="container w-500">
        <div class="cell center">
            <h2>[ 게임 유저 등록 ]</h2>
        </div>
        <div class="cell">
            <label>ID</label>
            <input type="text" name="gameUserId" placeholder="ex. user1" class="field w-100"
                onblur="checkUserId();" oninput="checkUserIdInput();">
            <div class="success-feedback">올바른 아이디입니다</div>
            <div class="fail-feedback">아이디가 형식에 맞지 않습니다. (* 1~8글자 한글, 영문, 숫자 가능)</div>
        </div>    
        <div class="cell">
            <label>직업</label>
            <select name="gameUserJob" class="field w-100" oninput="checkUserJob();">
                <option value="">선택하세요</option>
                <option>전사</option>
                <option>성직자</option>
                <option>도적</option>
            </select>
            <div class="success-feedback">직업 선택 완료</div>
            <div class="fail-feedback">직업은 반드시 선택하셔야 합니다</div>
        </div>
        
        <c:if test="${sessionScope.userLevel == '관리자'}">
            <div class="cell">
                <label>레벨</label>
                <input type="text" inputmode="numeric" name="gameUserLevel" class="field w-100" value="1"
                    onblur="checkUserLevel();" oninput="checkUserLevelInput();">
                <div class="success-feedback">레벨 설정 완료</div>
                <div class="fail-feedback">레벨은 1~100 사이로 설정해주세요</div>
            </div>
            <div class="cell">
                <label>소지 골드</label>
                <input type="text" inputmode="numeric" name="gameUserMoney" class="field w-100" value="0"
                    onblur="checkUserMoney();" oninput="checkUserMoneyInput();">
                <div class="success-feedback">소지 골드 설정 완료</div>
                <div class="fail-feedback">소지 골드를 설정해주세요</div>
            </div>
        </c:if>
        
        <div class="cell">
            <label>프로필 이미지</label>
            <input type="file" name="attach" class="field w-100" accept=".png, .jpg">
        </div>

        <div class="cell mt-30">
            <button type="submit" class="btn btn-positive w-100">
                <i class="fa-solid fa-plus"></i> 등록
            </button>
        </div>
    </div>
</form>
</body>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>