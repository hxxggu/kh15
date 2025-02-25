package com.kh.spring11;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test03마임메세지 {
	
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException {
		// sender 에게 기본 마임 메세지 인스턴스를 생성하도록 지시
		MimeMessage message = sender.createMimeMessage();
		
		// 복잡한 설정 과정을 도와주는 도우미를 생성
		MimeMessageHelper helper = new MimeMessageHelper(message, false, null); // multipart : 첨부파일을 쓸 것인지
		
		// 도우미를 통해서 메세지에 정보를 설정
		helper.setTo("kh15.semi.final@gmail.com"); // 한 개일 경우
//		helper.setTo("new String[] {"kh15.semi.final@gmail.com"}); // 여러 개일 경우
		helper.setSubject("마임메세지 테스트");
		helper.setText("<h2>HI!</h2>", true); // HTML 사용
		
		// 전송
		sender.send(message);
	}

}
