package com.kh.spring12.vo.kakaopay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;


// 카카오에서 준비 단계 완료 시 보내주는 데이터
// (* 주의) 자동으로 수신하려면 몇 가지 추가 설정이 필요함 (jackson-databind)
@Data
// builder는 필요가 없음.
@JsonIgnoreProperties(ignoreUnknown = true)
// : 해당 필드에 없는 것은 무시하라는 의미
// 해당 설정이 없으면 에러 발생
// * 꼭 responseVO에만 붙여야 한다. 에러가 나는 것은 아니지만, 혼용이 생길 수 있음.
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
// : 'Json은 snake_case이니까 변환하세요' 라는 의미
// 카멜케이스를 쓰기 위해서 적용
// Json을 쓸 때의 이름 규칙
public class KakaoPayReadyResponseVO {
	
	private String tid;
	private String nextRedirectPcUrl; // 결제 후 돌아가는 페이지
	private String createdAt;
	
}
