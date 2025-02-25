package com.kh.spring09.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kh.spring09.configuration.CertProperties;
import com.kh.spring09.dao.CertDao;
import com.kh.spring09.dto.CertDto;
import com.kh.spring09.util.RandomGenerator;

@Service
public class CertService { // service : 두 가지 이상의 일을 하기 위해 묶은 것
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private CertDao certDao;
	
	@Autowired
	private RandomGenerator randomGenerator;
	
	@Autowired
	private CertProperties certProperties;

	
	public void sendCertEmail(String email) { // 이메일을 받아서 인증번호를 만들고 메세지를 생성해서 전송
		// 인증 번호 생성
		String number = randomGenerator.randomNumber(8);
		
		// 메세지 생성
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email); // 수신자 설정
		message.setSubject("[kh정보교육원] 인증번호 안내"); // 제목 설정
		message.setText("인증 번호는 [ "+ number +" ] 입니다"); // 내용 설정
		sender.send(message); // 전송
		
		// (+추가) DB 등록
		certDao.insertOrUpdate(CertDto.builder()
						.certEmail(email)
						.certNumber(number)
					.build());
	}
	
	// 정기적으로 인증 정보 중 사용할 수 없는 것들을 제거하는 메서드
	
//	@Scheduled(cron = "0 30 9,18 * * *")
//	@Scheduled(cron = "0 30 9,18 * * 1")
//	@Scheduled(cron = "0 30 9,18 * * MON-FRI")
//	@Scheduled(cron = "0 0 13 25 * ?") // 매월 25일 정각13시 / ? : 무관을 의미
//	@Scheduled(cron = "0 0 9 ? * WED#1") // 매월 첫째 주 수요일, 아침 9시
//	@Scheduled(cron = "0 0 9 ? * 3L") // 매월 마지막 수요일 아침 9시
	// #n : n번째, L : 마지막
	
	@Scheduled(cron = "0 0 * * * *")
	public void work() {
		// System.out.println(LocalDateTime.now());
		certDao.clean(
				certProperties.getExpireMinutes(),
				certProperties.getExpireAccept()
		);
	}
		
}
