package com.kh.spring09.service;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.spring09.dto.MemberDto;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender sender;
	
	// 환영 메일 작성
	public void welcomeMail(MemberDto  memberDto) throws MessagingException, IOException {
		
		// sender에게 기본 마임메세지 인스턴스를 생성하도록 지시
		MimeMessage message = sender.createMimeMessage();
		
		// 복잡한 설정과정을 도와주는 도우미를 생성
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		// 도우미를 통해서 메세지에 정보를 설정
		helper.setTo("kh15.semi.final@gmail.com"); // 수신자 변경
		helper.setSubject("[KH 정보 교육원] 가입을 환영합니다"); // 제목 변경
		
		// 외부에 존재하는 템플릿 HTML을 불러와서 전송
		// - classpath : src 내부에 존재하는 위치
		// - filepath : 프로젝트 상의 위치
		
		ClassPathResource resource = new ClassPathResource("templates/welcome.html");
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
			element.text(memberDto.getMemberId());
		}
		
		// (+추가) .mylink 의 href 에 계산된 프로젝트의 전체 주소를 추가
		String contextPath = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				//.path("추가경로")
				//.queryParam("key", "value")
				.build().toUriString(); // 진입 지점
		Elements links = document.select(".mylink");
		for(Element element : links) {
			String href = element.attr("href"); // 기존에 작성된 href를 추출
			String newHref = contextPath + href; // 신규 href를 계산
			element.attr("href", newHref); // 신규 href를 태그에 설정
		}
		
		helper.setText(buffer.toString(), true); // HTML 사용
		
		// 전송
		sender.send(message);
	}
	
}
