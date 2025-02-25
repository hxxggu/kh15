package com.kh.spring11;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test03마임메세지4 {
	
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException, IOException {
		String memberId = "testuser123"; 
		
		// sender에게 기본 마임메세지 인스턴스를 생성하도록 지시
		MimeMessage message = sender.createMimeMessage();
		
		// 복잡한 설정과정을 도와주는 도우미를 생성
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		// 도우미를 통해서 메세지에 정보를 설정
		helper.setTo("kh15.semi.final@gmail.com");
		// helper.setTo(new String[] {"kh15.semi.final@gmail.com"});
		helper.setSubject("외부템플릿 테스트");
		
		// 외부에 존재하는 템플릿 HTML을 불러와서 전송
		// - classpath : src 내부에 존재하는 위치
		// - filepath : 프로젝트 상의 위치
		ClassPathResource resource = new ClassPathResource("templates/welcome2.html");
		File target = resource.getFile(); // 파일 추출
		Scanner sc = new Scanner(target); // 입력 도구
		StringBuffer buffer = new StringBuffer(); // 저장 버퍼 생성
		while(sc.hasNextLine()) { // 남아있는 줄이 있다면
			buffer.append(sc.nextLine()); // 읽어서 버퍼에 추가
		}
		sc.close(); // 도구 정리
		
		// buffer 의 내용을 HTML로 해석해서 원하는 값을 교체
		String html = buffer.toString();
		Document document = Jsoup.parse(html);
		Elements elements = document.select(".username");
		for(Element element : elements) {
			element.text(memberId);
		}
		
		helper.setText(buffer.toString(), true); // HTML 사용
		
		// 전송
		sender.send(message);
	}

}
