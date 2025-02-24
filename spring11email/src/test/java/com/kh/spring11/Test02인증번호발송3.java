package com.kh.spring11;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Properties;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.kh.spring11.configuration.EmailProperties;

@SpringBootTest
public class Test02인증번호발송3 {
	
	@Autowired
	//private JavaMailSenderImpl javaMailSenderImpl; // [1], [2] 를 대체
	private JavaMailSender sender; // [1], [2] 를 대체 (업캐스팅)
	
	@Test
	public void test() {
		System.out.println("단문 메세지 발송 테스트 시작");
		
		// [3]
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("kh15.semi.final@gmail.com"); // 수신인(여러개 가능)
		//message.setCc(null); // 참조인(여러개 가능)
		//message.setBcc(null); // 숨은 참조인(여러개 가능)
		
		// 인증 번호 생성
		Random r = new Random();
		int certNumber = r.nextInt(1000000); // 6자리
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		// symbols.setGroupingSeparator(' ');
		Format f = new DecimalFormat("000000");
		
		message.setSubject("[kh정보교육원] 인증번호 안내"); // 제목
		message.setText("인증 번호는 [ "+ f.format(certNumber) +" ] 입니다"); // 내용
		
		// [4]
		sender.send(message);
		
		System.out.println("단문 메세지 발송 테스트 종료");
	}
	
}