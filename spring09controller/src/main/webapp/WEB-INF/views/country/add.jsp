<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- head가 없으므로 상단에 배치 -->
<!-- 자바스크립트 작성 공간 -->
<script type="text/javascript">
    function checkCountryName() {
        var target = document.querySelector("[name = countryName]");
        var regex = /^[가-힣]{1,15}$/;
        var isValid = regex.test(target.value);
        target.classList.remove("success", "fail");
        target.classList.add(isValid ? "success" : "fail");

        return isValid;
    }

    function checkCountryCapital() {
        var target = document.querySelector("[name = countryCapital]");
        var regex = /^[가-힣]{1,15}$/;
        var isValid = regex.test(target.value);
        target.classList.remove("success", "fail");
        target.classList.add(isValid ? "success" : "fail");

        return isValid;
    }

    function checkCountryPopulation() {
        var target = document.querySelector("[name = countryPopulation]");
        // var regex = /^[0-9]+$/;
        // var isValid = regex.test(target.value);
        // :: 음수 범위 감지가 어려움
        var isValid = parseInt(target.value) > 0;
        target.classList.remove("success", "fail");
        target.classList.add(isValid ? "success" : "fail");
        return isValid;
    }

    function checkForm() {
        var countryNameValid = checkCountryName();
        var countryCaptalValid = checkCountryCapital();
        var countryPopulationValid = checkCountryPopulation();
        return countryNameValid && countryCaptalValid && countryPopulationValid;
    }
    
    // 추가) 입력창을 text로 두는 대신 숫자만 입력 가능하도록 구현
    function checkNumberInput() {
        var target = document.querySelector("[name = countryPopulation]");
        // target.value = target.value.replace("대상", "변경할 값");
        target.value = target.value.replace(/[^0-9]/g, "");
        // ^ : 아닌 것(not), g : 위치와 개수 상관없이 전부 변경하라
    }

</script>

<form action="add" method="post" enctype="multipart/form-data" autocomplete="off" onsubmit="return checkForm();">
	<div class="container w-500">
	
		<div class="cell center">
		    <h2>[ 국가 정보 등록 ]</h2>
		</div>
	
		<div class="cell">
		    <label>국가 명</label>
		    <input type="text" name="countryName" class="field w-100" onblur="checkCountryName();">
		</div>
	
		<div class="cell">
	    	<label>수도 명</label>
	    <input type="text" name="countryCapital" class="field w-100" onblur="checkCountryCapital();">
		</div>
		
		<div class="cell">
	    	<label>인구 수</label>
	    	<input type="text" name="countryPopulation" class="field w-100"
	              onblur="checkCountryPopulation();" oninput="checkNumberInput();">
		</div>
		
		<div class="cell">
		    <label>국기 이미지</label>
		    <input type="file" name="attach" class="field w-100">
		</div>
		
		<div class="cell mt-30">
		    <button class="btn btn-positive field w-100">
				<i class="fa-solid fa-plus"></i> 등록
			</button>
		</div>
		
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>