package com.kh.spring11;

import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test03마임메세지2 {
	
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException {
		//sender에게 기본 마임메세지 인스턴스를 생성하도록 지시
		MimeMessage message = sender.createMimeMessage();
		
		//복잡한 설정과정을 도와주는 도우미를 생성
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		//도우미를 통해서 메세지에 정보를 설정
		helper.setTo("kh15.semi.final@gmail.com");
		//helper.setTo(new String[] {"kh15.semi.final@gmail.com"});
		helper.setSubject("마임메세지 테스트");
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("<div style='padding:25px; border:1px solid black;'>");
		buffer.append("<h1 style='color:blue;'>Hello</h1>");
		buffer.append("</div>");
		
		helper.setText(buffer.toString(), true);//HTML 사용
		
		//전송
		sender.send(message);
	}

}
