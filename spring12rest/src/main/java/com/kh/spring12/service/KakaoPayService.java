package com.kh.spring12.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.spring12.configuration.KakaoPayProperties;
import com.kh.spring12.dao.BuyDao;
import com.kh.spring12.dao.ItemDao;
import com.kh.spring12.dto.BuyDetailDto;
import com.kh.spring12.dto.BuyDto;
import com.kh.spring12.dto.ItemDto;
import com.kh.spring12.vo.kakaopay.KakaoPayApproveResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayApproveVO;
import com.kh.spring12.vo.kakaopay.KakaoPayBuyVO;
import com.kh.spring12.vo.kakaopay.KakaoPayCancelResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayCancelVO;
import com.kh.spring12.vo.kakaopay.KakaoPayOrderResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayOrderVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KakaoPayService {
	
	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	@Autowired
	private BuyDao buyDao;
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HttpHeaders headers;
	
	// 결제 준비 (ready)
	public KakaoPayReadyResponseVO ready(KakaoPayReadyVO vo) throws URISyntaxException {
		// 2. 전송 주소 확인
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/ready");
		
		// 4. 바디 설정
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid()); // body.put("이름", "값");
		body.put("partner_order_id", vo.getPartnerOrderId());
		body.put("partner_user_id", vo.getPartnerUserId());
		body.put("item_name", vo.getItemName());
		body.put("quantity", "1");
		body.put("total_amount", String.valueOf(vo.getTotalAmount()));
		body.put("tax_free_amount", "0");
		// * 카카오페이 개발자센터 플랫폼에 등록된 주소로 시작해야 함
		// <규칙>
		// - 어떠한 주소가 오든 그 주소 뒤에 /success, /fail, /cancel 을 붙인다
		// - 성공 시에는 partnerOrderId를 경로 변수로 추가
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequest().toUriString(); // 현재 요청에 대한 주소를 구하라
		log.debug("baseUrl = {}", baseUrl);
		// VO로 partnerOrderId를 받음으로서 회원만 결제가 가능하도록 구현
		body.put("approval_url", baseUrl + "/success/"+vo.getPartnerOrderId());
		body.put("cancel_url", baseUrl + "/cancel/"+vo.getPartnerOrderId());
		body.put("fail_url", baseUrl + "/fail/"+vo.getPartnerOrderId());
		
		// 4 + 3
		HttpEntity entity = new HttpEntity(body, headers);
		
		// 2 + (4 + 3)
		KakaoPayReadyResponseVO response = restTemplate.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
		
		return response;
	}
	
	// 결제 승인 (approve)
	public KakaoPayApproveResponseVO approve(KakaoPayApproveVO vo) throws URISyntaxException{
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/approve");
		
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("tid", vo.getTid());
		body.put("partner_order_id", vo.getPartnerOrderId());
		body.put("partner_user_id", vo.getPartnerUserId());
		body.put("pg_token", vo.getPgToken());
		
		HttpEntity entity = new HttpEntity(body, headers);
		KakaoPayApproveResponseVO response = restTemplate.postForObject(uri, entity, KakaoPayApproveResponseVO.class);
		
		return response;
	}
	
	// 결제 조회 (order)
	public KakaoPayOrderResponseVO order(KakaoPayOrderVO vo) throws URISyntaxException {
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/order");
		
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("tid", vo.getTid());
		
		HttpEntity entity = new HttpEntity(body, headers);
		
		return restTemplate.postForObject(uri, entity, KakaoPayOrderResponseVO.class);
	}
	
	// 결제 취소 (cancel)
	public KakaoPayCancelResponseVO cancel(KakaoPayCancelVO vo) throws URISyntaxException {
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/cancel");
		
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("tid", vo.getTid());
		body.put("cancel_amount", String.valueOf(vo.getCancelAmount()));
		body.put("cancel_tax_free_amount", "0");
		
		HttpEntity entity = new HttpEntity(body, headers);
		
		return restTemplate.postForObject(uri, entity, KakaoPayCancelResponseVO.class);
	}
	
	// 결제 DB에 등록
	public void insertDB(
			KakaoPayApproveVO approveVO,
			KakaoPayReadyVO readyVO,
			List<KakaoPayBuyVO> buyList
			) {
		// buy 등록
		long buyNo = buyDao.addBuy(BuyDto.builder()
					.buyOwner(approveVO.getPartnerUserId()) // 주문자
					.buyTid(approveVO.getTid()) // 거래 번호
					.buyName(readyVO.getItemName()) // 구매상품
					.buyTotal(readyVO.getTotalAmount()) // 구매 금액
				.build());
		
		// buy_detail 등록 (반복문 사용)
		for(KakaoPayBuyVO buyVO : buyList) {
			ItemDto itemDto = itemDao.selectOne(buyVO.getItemNo());
			buyDao.addBuyDetail(BuyDetailDto.builder()
						.buyDetailOrigin(buyNo) // 구매 대표 번호
						.buyDetailItem(buyVO.getItemNo()) // 구매 상품 번호
						.buyDetailName(itemDto.getItemName()) // 구매 상품명
						.buyDetailPrice(itemDto.getRealPrice()) // 구매 상품 가격 (개당)
						.buyDetailQty(buyVO.getQty()) // 구매 상품 개수
					.build());
		}
	}
}
