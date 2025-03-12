<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- Lightpick 라이브러리 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/lightpick@1.6.2/css/lightpick.min.css">
<script src="https://cdn.jsdelivr.net/npm/moment@2.30.1/moment.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/lightpick@1.6.2/lightpick.min.js"></script>

<!-- kakao post api -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/js/member/join.js" ></script>
<!-- kakao map cdn -->
<style>
	#map {
		width:300px;
		height:200px;
		display:none;
	}
	.field {
		border-radius: 10px;
	}
</style>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=430cecda328081e9c3c1420be135b9dd&libraries=services"></script>
<script type="text/javascript">
	$(function(){
		$("[name=memberAddress2]").blur(function(){
			var post = $("[name=memberPost]").val();
			var address1 = $("[name=memberAddress1]").val();
			var address2 = $("[name=memberAddress2]").val();
			
			var isFill = post.length > 0 && address1.length > 0 && address2.length > 0;
			
			if(isFill) {
				//지도 생성(+주소 검색)
				$("#map").show();
				
				var address = address1 + " " + address2;
				
				//주소-좌표 변환도구 생성
                var geocoder = new kakao.maps.services.Geocoder();

                //도구를 이용해서 좌표를 검색
                //geocoder.addressSearch(주소, 콜백함수);
                geocoder.addressSearch(address, function(result, status){
                    //console.log(arguments);//함수에 전달되는 모든 인자를 확인
                    //if(status == "OK") {//검색 성공
                    if(status === kakao.maps.services.Status.OK) {//검색 성공
                        //console.log(result[0].x, result[0].y);//경도, 위도
                        
                        var location = new kakao.maps.LatLng(result[0].y, result[0].x);
                        
                        //지도 생성
                        var container = document.querySelector("#map");//JS
                        var options = {
							center: new kakao.maps.LatLng(location.getLat(), location.getLng()),
							level: 3
                        };
                        var map = new kakao.maps.Map(container, options);
                        map.setDraggable(false);
                        map.setZoomable(false);
                        
                        //마커 생성
                        var marker = new kakao.maps.Marker({
                            map: map,//지도 설정
                            position: location,//위치 설정
                        });
                    }
                    else {
						$("#map").empty().hide();                    	
                    }
                });
			}
			else {
				//지도 삭제
				$("#map").empty().hide();
			}
		});
	});
</script>

<form class="form-check" action="" method="post" enctype="multipart/form-data" autocomplete="off">

	<div class="container w-500">
	
		<div class="cell center">
		     <h2>Join In</h2>
		     <p>
		     	회원 정보 입력<br>
		     	* 항목은 필수 입력 항목입니다
		     </p>
		 </div>
		 
		 <!-- 아이디 -->
		<div class="cell">
		    <label><i class="fa-regular fa-user"></i> ID</label>
		    <input type="text" name="memberId" class="field w-100" placeholder="* 아이디">
		    <div class="fail-feedback">형식에 맞지 않는 아이디입니다</div>
		    <div class="fail2-feedback">이미 사용중인 아이디입니다</div>
		    <div class="success-feedback">사용 가능 아이디 <i class="fa-regular fa-face-smile"></i></div>
		</div>
		
		<!-- 비밀번호 -->
		<div class="cell">
		    <label><i class="fa-solid fa-lock"></i> Password </label>
		    <input type="password" name="memberPw" class="field w-100" placeholder="* 비밀번호">
		    <div class="fail-feedback">비밀번호가 형식에 맞지 않습니다</div>
		    <div class="success-feedback">비밀번호 입력 완료 <i class="fa-regular fa-face-smile"></i></div>
		</div>
		
		<!-- 비밀번호 확인 -->
		<div class="cell">
		    <label><i class="fa-solid fa-lock"></i> Password Check </label>
		    <input type="password" id="pw-reinput" class="field w-100" placeholder="* 비밀번호 확인">
		    <div class="success-feedback">비밀번호 확인 완료 <i class="fa-regular fa-face-smile"></i></div>
		    <div class="fail-feedback">비밀번호가 일치하지 않습니다</div>
		    <div class="fail2-feedback">비밀번호를 우선 입력해주세요</div>
		</div>
		 
		 <!-- 닉네임 -->
		<div class="cell">
			<label><i class="fa-regular fa-face-kiss-wink-heart"></i> Nickname</label>
			<input type="text" name="memberNickname" class="field w-100" placeholder="* 닉네임">
	        <div class="success-feedback">닉네임 설정 완료 <i class="fa-regular fa-face-smile"></i></div>
	        <div class="fail-feedback">닉네임은 한글 또는 숫자 2~10자로 작성하세요</div>
	        <div class="fail2-feedback">이미 사용중인 닉네임 입니다</div>
		</div>
		
		<!-- 이메일  -->
	    <div class="cell">
	    	<label style="display:block;"><i class="fa-regular fa-envelope"></i> 이메일</label>
	    </div>
	    <div class="cell">
	        <input type="email" inputmode="email" name="memberEmail" class="field"  placeholder="* 이메일">
	        <button type="button" class="btn btn-purple btn-send-cert">
	        	<i class="fa-regular fa-paper-plane"></i>
	        	<span>인증메일발송</span>
	        </button>
	        <div class="fail-feedback">이메일은 필수 항목입니다</div>
	    </div>
	    <div class="cell cert-input-wrapper" style="display:none;">
	    	<input type="text" inputmode="numeric" class="field" name="certNumber" placeholder="인증번호 입력">
	    	<button type="button" class="btn btn-pink btn-confirm-cert">
	    		<i class="fa-solid fa-check"></i>
	    		<span>인증 확인</span>
	    	</button>
			<div class="success-feedback">인증이 완료되었습니다</div>
	    	<div class="fail-feedback">인증 번호가 일치하지 않습니다</div>
	    </div>

		<!-- 생년월일 -->
		<div class="cell">
		    <label><i class="fa-solid fa-cake-candles"></i> 생년월일</label>
		    <input type="text" name="memberBirth" class="field w-100" placeholder="* 생년월일">
		    <div class="fail-feedback">생년월일을 입력해주세요</div>
		    <div class="success-feedback">생년월일 입력 완료</div>
		</div>
		
		<!-- 핸드폰 번호 -->
		<div class="cell">
		    <label> <i class="fa-solid fa-mobile-screen-button"></i> 연락처</label>
		    <input type="tel" name="memberContact" class="field w-100" placeholder="[선택] 연락처">
		    <div class="fail-feedback">형식이 맞지 않습니다</div>
		    <div class="success-feedback"></div>
		</div>
		
		<!-- 주소 -->
		<div class="cell">
		    <label><i class="fa-solid fa-location-dot"></i> 주소</label>
		</div>
		<div class="cell">
		    <input type="text" name="memberPost" size="6" maxlength="6" class="field" placeholder="우편번호">
		    <button type="button" class="btn btn-purple"><i class="fa-solid fa-magnifying-glass"></i></button>
		    <button type="button" class="btn btn-red btn-address-clear" style="display: none;">
		        <i class="fa-solid fa-xmark"></i>
		    </button>
		</div>
		<div class="cell">
		    <input type="text" name="memberAddress1" class="field w-100" placeholder="기본주소">
		</div>
		<div class="cell">
		    <input type="text" name="memberAddress2" class="field w-100" placeholder="상세주소">
		    <div class="fail-feedback">주소는 모두 작성하셔야 합니다</div>
		</div>
        <!-- 지도 영역 -->
       <div class="cell">
       	<div id="map"></div>
       </div>
		<div class="cell center">
		    <button class="btn btn-pink w-100"><i class="fa-solid fa-arrow-right-to-bracket"></i> 가입하기</button>
		</div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>