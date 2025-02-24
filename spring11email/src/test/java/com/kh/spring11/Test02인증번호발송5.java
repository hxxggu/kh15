package com.kh.spring11;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.kh.spring11.dao.CertDao;
import com.kh.spring11.dto.CertDto;
import com.kh.spring11.util.RandomGenerator;

@SpringBootTest
public class Test02인증번호발송5 {
	
	@Autowired
	//private JavaMailSenderImpl sender;//[1], [2]을 대체
	private JavaMailSender sender;//[1], [2]을 대체 (업캐스팅)
	
	@Autowired
	private CertDao certDao;
	
	@Autowired
	private RandomGenerator randomGenerator;

	@Test
	public void test() {
		System.out.println("단문 메세지 발송 테스트 시작");
		
		//인증번호 생성
		String number = randomGenerator.randomNumber(8);
		String email = "kh15.semi.fanal@gmail.com";//수신인
		
		//[3]
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		
		message.setSubject("[KH정보교육원] 인증번호 안내");//제목
		message.setText("인증번호는 ["+number+"] 입니다");//내용
		
		//[4]
		sender.send(message);
		
		//(+추가) DB등록
		certDao.insertOrUpdate(CertDto.builder()
					.certEmail(email)
					.certNumber(number)
				.build());
		
		System.out.println("단문 메세지 발송 테스트 종료");
	}
	
}